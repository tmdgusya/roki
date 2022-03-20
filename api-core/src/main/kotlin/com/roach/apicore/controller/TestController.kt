package com.roach.apicore.controller

import com.example.domain.application.GithubLoginFacade
import com.example.domain.model.GithubAuthModel
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestController(
    private val githubLoginFacade: GithubLoginFacade
) {

    @PostMapping
    fun test(@RequestBody githubAuthModel: GithubAuthModel.In): String {
        return githubLoginFacade.authorize(githubAuthModel)
    }

    @GetMapping("/auth")
    fun test2(): String {
        return "ok"
    }

    companion object {
        private val log = LoggerFactory.getLogger(TestController::class.java)
    }
}
