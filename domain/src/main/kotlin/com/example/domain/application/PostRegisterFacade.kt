package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.model.PostRegisterModel
import com.example.domain.service.PostCommandService

@UseCase
class PostRegisterFacade(
    private val postCommandService: PostCommandService
) {

    fun registerPost(postRegisterModel: PostRegisterModel.In) {
        postCommandService.register(postRegisterModel)
    }
}
