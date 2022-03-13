package com.example.domain

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(
    value = ["com.example.domain.entity"]
)
@EnableJpaRepositories(
    value = ["com.example.domain.repository"]
)
@EnableJpaAuditing
class JpaConfiguration
