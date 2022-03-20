package com.example.externalapi

import com.example.externalapi.clients.github.GithubClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(
    clients = [GithubClient::class]
)
@ComponentScan(
    basePackageClasses = [FeignConfiguration::class]
)
class FeignConfiguration
