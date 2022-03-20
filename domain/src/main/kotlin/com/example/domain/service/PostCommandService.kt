package com.example.domain.service

import com.example.domain.model.PostRegisterModel
import com.example.domain.model.PostUpdateModel
import com.example.domain.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PostCommandService(
    private val repository: PostRepository
) {

    @Transactional
    fun register(postRegisterModel: PostRegisterModel.In) {
        repository.save(postRegisterModel.toPost())
    }

    @Transactional
    fun updatePost(postUpdateModel: PostUpdateModel.In) {
        val post = repository.findById(postUpdateModel.postId).orElseThrow {
            throw IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        }
        post.updatePost(
            title = postUpdateModel.title,
            content = postUpdateModel.content
        )

        repository.save(post)
    }

    @Transactional
    fun deletePost(postId: Long) {
        val post = repository.findById(postId).orElseThrow {
            throw IllegalArgumentException("해당 게시물이 존재하지 않습니다.")
        }

        repository.delete(post)
    }
}
