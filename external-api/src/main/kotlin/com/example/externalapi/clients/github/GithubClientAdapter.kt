package com.example.externalapi.clients.github

import org.springframework.stereotype.Service

@Service
class GithubClientAdapter(
    private val githubClient: GithubClient
) {

    fun getUserProfile(authToken: String): GithubUserProfileInfo {
        return githubClient.getUserProfile(
            authToken = "token $authToken"
        )
    }
}
