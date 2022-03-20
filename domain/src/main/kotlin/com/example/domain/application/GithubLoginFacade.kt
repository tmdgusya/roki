package com.example.domain.application

import com.example.domain.UseCase
import com.example.externalapi.clients.github.GithubClientAdapter

@UseCase
class GithubLoginFacade(
    private val githubClient: GithubClientAdapter
) {

    fun authorize() {
        return githubClient.authorize()
    }
}
