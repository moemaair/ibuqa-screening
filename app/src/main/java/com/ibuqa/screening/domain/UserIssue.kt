package com.ibuqa.screening.domain

data class UserIssue(
    val createdAt: Any,
    val author: String,
    val title: String,
    val body: String?,
    val commentsCount: Int,
    val state: String
)


