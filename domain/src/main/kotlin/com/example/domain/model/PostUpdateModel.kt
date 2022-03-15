package com.example.domain.model

class PostUpdateModel private constructor() {

    data class In(
        val postId: Long,
        val title: String,
        val content: String,
    )
}
