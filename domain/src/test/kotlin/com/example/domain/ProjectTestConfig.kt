package com.example.domain

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringExtension

object ProjectTestConfig : AbstractProjectConfig() {
    override val parallelism = 3

    override fun extensions() = listOf(SpringExtension)
}
