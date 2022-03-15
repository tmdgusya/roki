package com.example.domain

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

@SpringBootApplication
@Import(DomainBeanMarker::class)
class DomainApplicationTests
