package com.roach.apicore.model

import com.example.domain.model.PostUpdateModel

class PostUpdate {

    data class Request(
        val postId: Long,
        val title: String,
        val contents: String
    ) {
        fun toModel(): PostUpdateModel.In {
            return PostUpdateModel.In(
                postId = postId,
                title = title,
                content = contents
            )
        }
    }
}
