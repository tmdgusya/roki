package com.example.domain.model

class GetUserProfilePort {

    data class Out(
        val userId: String,
        val avatarUrl: String,
        val githubUrl: String,
        val email: String
    )
}
