package com.roach.apicore

import com.example.domain.DomainBeanMarker
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Import(DomainBeanMarker::class)
@Configuration
class ApiConfiguration
