package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.model.GithubAuthModel
import com.example.externalapi.clients.github.GithubAuthorizeModel
import com.example.externalapi.clients.github.GithubClientAdapter
import org.slf4j.LoggerFactory

@UseCase
class GithubLoginFacade(
    private val githubClient: GithubClientAdapter
) {

    fun authorize(githubAuthModel: GithubAuthModel.In): String {
        val request = GithubAuthorizeModel.Request.from(
            secretId = githubAuthModel.secretId,
            clientSecret = githubAuthModel.clientSecret,
            code = githubAuthModel.code
        )
        return githubClient.authorize(request)
    }

    companion object {
        private val log = LoggerFactory.getLogger(GithubLoginFacade::class.java)
    }
}
