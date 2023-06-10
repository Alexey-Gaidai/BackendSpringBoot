package com.example.BackendSpringBoot.repositories

import com.example.BackendSpringBoot.model.Weather
import org.springframework.data.jpa.repository.JpaRepository

interface WeatherRepository: JpaRepository<Weather, Long> {
    fun findByDatetimeAndCity(datetime: Long, city: String): Weather?
    fun findByDatetimeBetweenAndCity(startDateTime: Long, endDateTime: Long, city: String): List<Weather>?
}