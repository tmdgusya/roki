package com.example.externalapi.clients.github

import org.springframework.stereotype.Service

@Service
class GithubClientAdapter(
    private val githubClient: GithubClient
) {

    fun authorize() {
        return githubClient.authorize()
    }
}
