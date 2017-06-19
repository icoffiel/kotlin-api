package com.nerdery.kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinApiApplication::class.java, *args)
}
