package com.example.domain.model

import com.example.domain.entity.User

class UserRegisterFormModel private constructor() {

    data class In(
        val userEmail: String,
        val password: String
    ) {
        fun toEntity(): User {
            return User(
                email = userEmail,
                password = password,
                role = Role.REGISTERED_USER.name
            )
        }
    }
}
