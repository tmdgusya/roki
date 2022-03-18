package com.example.domain.service

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class UserCommandService(
    private val userRepository: UserRepository
) {

    @Transactional
    fun register(user: User) {
        userRepository.save(user)
    }
}
