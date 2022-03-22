package com.roach.apicore.controller

import com.example.domain.application.GithubLoginFacade
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserRegisterController(
    private val githubLoginFacade: GithubLoginFacade
) {

    @PostMapping("/github-users")
    fun registerWithGithub(
        @RequestParam("clientId") clientId: String,
        @RequestParam("clientSecret") clientSecret: String,
        @RequestParam("code") code: String
    ) {
        githubLoginFacade.getUserProfile(
            clientId = clientId,
            clientSecret = clientSecret,
            code = code
        )
    }
}
