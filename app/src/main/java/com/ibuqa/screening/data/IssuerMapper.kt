package com.ibuqa.screening.data



import com.ibuqa.UserRepositoryQuery
import com.ibuqa.screening.domain.UserIssue

fun UserRepositoryQuery.Node.toIssues(): UserIssue{
    return UserIssue(
        createdAt = createdAt,
        author = author?.login.toString(),
        title = title,
        body = body,
        commentsCount = comments.totalCount,
        state = state.name.toString()
    )
}


