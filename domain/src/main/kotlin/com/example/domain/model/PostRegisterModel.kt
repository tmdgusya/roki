package com.example.domain.model

import com.example.domain.entity.Post

class PostRegisterModel private constructor() {

    data class In(
        val title: String,
        val content: String
    ) {
        fun toPost(): Post {
            return Post(
                title = title,
                content = content
            )
        }
    }
}
