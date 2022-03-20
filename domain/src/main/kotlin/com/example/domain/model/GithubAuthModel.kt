package com.example.domain.model

import com.example.externalapi.clients.github.GithubAuthorizeModel

class GithubAuthModel private constructor() {
    data class In(
        val secretId: String,
        val clientSecret: String,
        val code: String
    )

    data class Out(
        val accessToken: String,
        val scope: String,
        val tokenType: String
    ) {
        companion object {
            fun toResponse(githubAuthorizeModel: GithubAuthorizeModel.Response): Out {
                return Out(
                    accessToken = githubAuthorizeModel.access_token,
                    scope = githubAuthorizeModel.scope,
                    tokenType = githubAuthorizeModel.token_type,
                )
            }
        }
    }
}
