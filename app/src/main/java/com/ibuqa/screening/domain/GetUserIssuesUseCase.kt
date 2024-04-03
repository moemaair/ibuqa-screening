package com.ibuqa.screening.domain

import com.ibuqa.screening.presentation.MainViewModel

class GetUserIssuesUseCase(
    private val issue: IssueClient,

) {

    suspend fun execute(query: String): List<UserIssue> {
        val fullquery = "repo:$query" // Concatenate the query parameter with the constant string
        return issue
            .getIssues(fullquery)

    }

}