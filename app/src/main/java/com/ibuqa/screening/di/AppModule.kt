package com.ibuqa.screening.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.ibuqa.screening.constants.Constants.GITHUB_TOKEN
import com.ibuqa.screening.data.ApolloGraphqlClient
import com.ibuqa.screening.domain.GetUserIssuesUseCase
import com.ibuqa.screening.domain.IssueClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        val authInterceptor = Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()

                // Replace "your_bearer_token_here" with your actual token
                .header("Authorization", "Bearer $GITHUB_TOKEN")

            val request = requestBuilder.build()
            chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()

        return ApolloClient.Builder()
            .serverUrl("https://api.github.com/graphql")
            .okHttpClient(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideApolloClients(apolloClient: ApolloClient): IssueClient{
        return ApolloGraphqlClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetIssuesUseCase(issueClient: IssueClient): GetUserIssuesUseCase {
        return GetUserIssuesUseCase(issueClient)
    }

}

