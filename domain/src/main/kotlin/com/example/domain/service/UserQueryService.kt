package com.example.domain.service

import com.example.domain.entity.User
import com.example.domain.repository.UserRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional(readOnly = true)
class UserQueryService(
    private val userRepository: UserRepository
) {

    fun findOne(userId: Long): User {
        return userRepository.findById(userId).orElseThrow {
            throw IllegalArgumentException("해당 유저를 찾을 수 없습니다.")
        }
    }

    fun checkExist(userEmail: String): Boolean {
        return userRepository.existsByUserEmail(userEmail) == EXIST_USER
    }

    companion object {
        private const val EXIST_USER = 1
    }
}
