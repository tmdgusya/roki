package com.example.domain.service

import com.example.domain.model.PostRegisterModel
import com.example.domain.model.PostUpdateModel
import com.example.domain.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostCommandService(
    private val repository: PostRepository
) {

    fun register(postRegisterModel: PostRegisterModel.In) {
        repository.save(postRegisterModel.toPost())
    }

    fun updatePost(postUpdateModel: PostUpdateModel.In) {
        val post =
            repository.findByPostId(postUpdateModel.postId) ?: throw IllegalArgumentException("해당 게시물이 존재하지 않습니다.")

        post.updatePost(
            title = postUpdateModel.title,
            content = postUpdateModel.content
        )

        repository.save(post)
    }

    fun deletePost(postId: Long) {
        val post = repository.findByPostId(postId) ?: throw IllegalArgumentException("해당 게시물이 존재하지 않습니다.")

        repository.delete(post)
    }
}
