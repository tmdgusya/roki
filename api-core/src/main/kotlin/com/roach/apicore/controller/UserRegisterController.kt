package com.roach.apicore.controller

import com.example.domain.application.GithubLoginFacade
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class UserRegisterController(
    private val githubLoginFacade: GithubLoginFacade
) {

    @PostMapping("/github-users")
    fun registerWithGithub(
        @RequestHeader("Authorization") authToken: String
    ) {
        githubLoginFacade.getUserProfile(
            authToken = authToken
        )
    }
}
