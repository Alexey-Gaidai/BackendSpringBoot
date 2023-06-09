package com.example.BackendSpringBoot.repositories

import com.example.BackendSpringBoot.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Int> {
    fun findByEmail(email: String): User?
}