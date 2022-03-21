package com.example.externalapi.clients.github

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(
    name = "github-client",
    url = "https://api.github.com"
)
interface GithubClient {

    @GetMapping("/user")
    fun getUserProfile(@RequestHeader("Authorization") authToken: String): GithubUserProfileInfo
}
