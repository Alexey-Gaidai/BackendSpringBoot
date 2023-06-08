package com.example.BackendSpringBoot.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("api/hello")
class HelloWorldController  {
        @GetMapping
        fun helloWorld(): String {
            return "Hello World! This is a Spring Boot Backend!"
        }
}