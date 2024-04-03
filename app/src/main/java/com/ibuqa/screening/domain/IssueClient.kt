package com.ibuqa.screening.domain

interface IssueClient {
    //INTERFACE to interact with github API
    suspend fun getIssues(query: String): List<UserIssue>
}