package com.example.BackendSpringBoot.dto

class Message(private val message: String) {
    override fun toString(): String {
        return "Message(message='$message')"
    }
}