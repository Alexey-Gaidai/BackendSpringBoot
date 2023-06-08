package com.example.BackendSpringBoot.controllers

import com.example.BackendSpringBoot.models.Weather
import com.example.BackendSpringBoot.service.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/banks")
class WeatherController(private val service: WeatherService) {

    @GetMapping
    fun getBanks(): Collection<Weather> = service.getBanks()
}