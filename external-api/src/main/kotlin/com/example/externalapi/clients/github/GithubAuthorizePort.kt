package com.example.externalapi.clients.github

class GithubAuthorizePort private constructor() {
    data class In(
        val client_id: String,
        val client_secret: String,
        val code: String
    )

    data class Response(
        val access_token: String,
        val scope: String,
        val token_type: String
    )
}
