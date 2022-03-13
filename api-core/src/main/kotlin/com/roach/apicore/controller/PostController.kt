package com.roach.apicore.controller

import com.example.domain.application.PostRegisterFacade
import com.roach.apicore.model.PostRegister
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postRegisterFacade: PostRegisterFacade
) {

    @PostMapping
    fun register(@RequestBody postRegisterModel: PostRegister.Request) {
        postRegisterFacade.registerPost(postRegisterModel.toModel())
    }
}
