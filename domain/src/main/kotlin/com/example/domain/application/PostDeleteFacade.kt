package com.example.domain.application

import com.example.domain.UseCase
import com.example.domain.service.PostCommandService

@UseCase
class PostDeleteFacade(
    private val postCommandService: PostCommandService
) {

    fun execute(postId: Long) {
        postCommandService.deletePost(postId)
    }
}
