package com.ibuqa.screening.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.exception.ApolloException
import com.ibuqa.UserRepositoryQuery


import com.ibuqa.screening.domain.IssueClient
import com.ibuqa.screening.domain.UserIssue


class ApolloGraphqlClient(
    private val apolloClient: ApolloClient
) : IssueClient {

    override suspend fun getIssues(query: String): List<UserIssue> {
        return apolloClient
            .query(UserRepositoryQuery(query))
            .execute()
            .data
            ?.search
            ?.repos
            ?.flatMap { repoEdge ->
                repoEdge?.repo?.onRepository?.issues?.nodes?.mapNotNull { issue ->
                    issue?.toIssues()
                } ?: emptyList()
            }
            ?: emptyList()

    }
}



