package com.roach.apicore.controller

import com.example.domain.application.PostRegisterFacade
import com.example.domain.application.PostUpdateFacade
import com.roach.apicore.model.PostRegister
import com.roach.apicore.model.PostUpdate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postRegisterFacade: PostRegisterFacade,
    private val postUpdateFacade: PostUpdateFacade,
) {

    /**
     * AWS Infra 에서 front-end 에서만 api 호출 가능하도록 방어 예정
     */
    @PostMapping
    fun register(@RequestBody postRegisterModel: PostRegister.Request) {
        postRegisterFacade.registerPost(postRegisterModel.toModel())
    }

    @PutMapping
    fun update(@RequestBody postUpdateModel: PostUpdate.Request) {
        postUpdateFacade.update(postUpdateModel.toModel())
    }
}
