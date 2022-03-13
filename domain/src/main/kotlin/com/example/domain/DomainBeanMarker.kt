package com.example.domain

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Domain Package 를 사용하기 위해서는 해당 Class 를 Import 해야 함.
 */
@Configuration
@ComponentScan(
    value = ["com.example.domain"]
)
class DomainBeanMarker
