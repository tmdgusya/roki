package com.example.externalapi.clients.github

class GithubAuthorizePort private constructor() {
    data class In(
        val client_id: String,
        val client_secret: String,
        val code: String
    ) {
        companion object {
            fun from(
                secretId: String,
                clientSecret: String,
                code: String
            ): In {
                return In(
                    client_id = secretId,
                    client_secret = clientSecret,
                    code = code
                )
            }
        }
    }

    data class Response(
        val access_token: String,
        val scope: String,
        val token_type: String
    )
}
