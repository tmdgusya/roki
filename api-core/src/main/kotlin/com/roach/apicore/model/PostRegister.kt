package com.roach.apicore.model

import com.example.domain.model.PostRegisterModel

class PostRegister private constructor() {

    data class Request(
        val title: String,
        val content: String
    ) {

        fun toModel(): PostRegisterModel.In {
            return PostRegisterModel.In(
                title = title,
                content = content
            )
        }
    }
}
