package com.example.externalapi.clients.github

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "git-hub-authorization",
    url = "https://github.com/login/oauth"
)
interface GithubAuthorizationClient {

    @PostMapping("/access_token")
    fun getAuthorizationToken(
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("code") code: String
    ): String
}
