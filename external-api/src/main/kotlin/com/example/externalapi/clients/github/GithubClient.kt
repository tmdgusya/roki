package com.example.externalapi.clients.github

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "github-client",
    url = "https://github.com",
)
interface GithubClient {

    companion object {
        private const val REDIRECT_URL: String = "http://localhost:8080/oauth"
        private const val CLIENT_ID: String = "3da9a6e57d7ca3b4fa16"
    }

    @GetMapping("/login/oauth/authorize")
    fun authorize(
        @RequestParam("client_id") clientId: String = CLIENT_ID,
        @RequestParam("redirect_url") redirectUrl: String = REDIRECT_URL,
        @RequestParam("login") login: String? = null,
        @RequestParam("scope") scope: String? = null,
        @RequestParam("state") state: String? = null,
        @RequestParam("allow_signup") allowSignup: String? = null,
    )
}
