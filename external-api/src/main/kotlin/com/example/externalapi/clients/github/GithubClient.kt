package com.example.externalapi.clients.github

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
    name = "github-client",
    url = "https://github.com/login",
)
interface GithubClient {

    @PostMapping("/oauth/access_token")
    fun authorize(
        @RequestParam("client_id") clientId: String,
        @RequestParam("client_secret") clientSecret: String,
        @RequestParam("code") code: String
    ): String
}
