package com.example.BackendSpringBoot.service

import com.example.BackendSpringBoot.model.User
import com.example.BackendSpringBoot.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }

    //fun save user
    fun save(user: User): User {
        return userRepository.save(user)
    }
}