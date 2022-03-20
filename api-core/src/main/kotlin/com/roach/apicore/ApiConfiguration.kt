package com.roach.apicore

import com.example.domain.DomainBeanMarker
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(DomainBeanMarker::class)
class ApiConfiguration
