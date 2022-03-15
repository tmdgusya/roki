package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.model.PostUpdateModel
import com.example.domain.service.PostCommandService

@UseCase
class PostUpdateFacade(
    private val postCommandService: PostCommandService
) {

    fun update(postUpdateModel: PostUpdateModel.In) {
        postCommandService.updatePost(postUpdateModel)
    }
}
