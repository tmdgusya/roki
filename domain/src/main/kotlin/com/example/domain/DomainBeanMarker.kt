package com.example.domain

import com.example.externalapi.FeignConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * Domain Package 를 사용하기 위해서는 해당 Class 를 Import 해야 함.
 */
@Configuration
@Import(FeignConfiguration::class)
@ComponentScan(
    value = ["com.example.domain"]
)
class DomainBeanMarker
