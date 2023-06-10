package com.example.BackendSpringBoot.controllers

import com.example.BackendSpringBoot.model.Weather
import com.example.BackendSpringBoot.service.WeatherService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/weather")
class WeatherController(private val service: WeatherService) {

    @GetMapping("{city}")
    fun getWeatherForToday(@PathVariable city: String): List<Weather>? {
        service.saveWeatherForecast(city)
        return service.getWeatherForToday(city)
    }
}