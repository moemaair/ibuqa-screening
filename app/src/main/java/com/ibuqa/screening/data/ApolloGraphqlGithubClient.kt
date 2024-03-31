package com.ibuqa.screening.data

import com.ibuqa.screening.domain.IssueClient
import com.ibuqa.screening.domain.UserIssue

class ApolloGraphqlGithubClient(
    private val apolloGraphqlGithubClient: ApolloGraphqlGithubClient
): IssueClient{
    override suspend fun getIssues(): List<UserIssue> {
        TODO("Not yet implemented")
    }

}