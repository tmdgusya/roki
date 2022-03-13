package com.example.domain

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration

@Configuration
@EntityScan(
    value = ["com.example.domain.entity"]
)
class JpaConfiguration
