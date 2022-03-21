package com.example.externalapi.clients.github

import org.springframework.stereotype.Service

@Service
class GithubClientAdapter(
    private val githubClient: GithubClient
) {

    fun authorize(githubAuthorizeModel: GithubAuthorizePort.In): String {
        return githubClient.authorize(
            clientId = githubAuthorizeModel.client_id,
            clientSecret = githubAuthorizeModel.client_secret,
            code = githubAuthorizeModel.code
        )
    }
}
