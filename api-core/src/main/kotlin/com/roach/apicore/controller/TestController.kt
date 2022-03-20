package com.roach.apicore.controller

import com.example.domain.application.GithubLoginFacade
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestController(
    private val githubLoginFacade: GithubLoginFacade
) {

    fun test() {
        return githubLoginFacade.authorize()
    }
}
