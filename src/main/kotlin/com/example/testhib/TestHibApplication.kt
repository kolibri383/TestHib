package com.example.testhib

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestHibApplication

fun main(args: Array<String>) {
    runApplication<TestHibApplication>(*args)
}
