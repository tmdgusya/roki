package com.example.domain.service

import com.example.domain.model.PostRegisterModel
import com.example.domain.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostCommandService(
    private val repository: PostRepository
) {

    fun register(postRegisterModel: PostRegisterModel.In) {
        repository.save(postRegisterModel.toPost())
    }
}
