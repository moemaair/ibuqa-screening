package com.ibuqa.screening.domain

data class UserIssue(
    val createdAt: String,
    val title: String,
    val body: String?,
    val editorAvatarUrl: String?,
    val commentsCount: Int
)


