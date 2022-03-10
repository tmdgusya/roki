package com.roach.roki

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RokiApplication

fun main(args: Array<String>) {
	runApplication<RokiApplication>(*args)
}
