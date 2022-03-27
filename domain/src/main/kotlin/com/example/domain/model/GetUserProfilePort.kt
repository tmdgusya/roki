package com.example.domain.model

class GetUserProfilePort {

    data class Out(
        val role: Role,
        val avatarUrl: String?,
        val githubUrl: String?,
        val email: String
    )
}
