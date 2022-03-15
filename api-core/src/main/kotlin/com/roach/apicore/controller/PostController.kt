package com.roach.apicore.controller

import com.example.domain.application.PostDeleteFacade
import com.example.domain.application.PostRegisterFacade
import com.example.domain.application.PostUpdateFacade
import com.roach.apicore.model.PostRegister
import com.roach.apicore.model.PostUpdate
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
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
    private val postDeleteFacade: PostDeleteFacade,
) {

    /**
     * AWS Infra 에서 front-end 에서만 api 호출 가능하도록 방어 예정
     */
    @PostMapping
    fun register(@RequestBody postRegisterModel: PostRegister.Request) {
        postRegisterFacade.execute(postRegisterModel.toModel())
    }

    @PutMapping
    fun update(@RequestBody postUpdateModel: PostUpdate.Request) {
        postUpdateFacade.execute(postUpdateModel.toModel())
    }

    @DeleteMapping("/{postId}")
    fun delete(@PathVariable("postId") postId: Long) {
        postDeleteFacade.execute(postId)
    }
}
