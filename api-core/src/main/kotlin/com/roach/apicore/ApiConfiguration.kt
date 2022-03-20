package com.roach.apicore

import com.example.domain.DomainBeanMarker
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@EnableFeignClients(
    basePackageClasses = [ApiConfiguration::class]
)
@Import(DomainBeanMarker::class)
class ApiConfiguration
