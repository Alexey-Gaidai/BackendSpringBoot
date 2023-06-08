package com.example.BackendSpringBoot.controllers

import com.example.BackendSpringBoot.models.Weather
import com.example.BackendSpringBoot.service.WeatherService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/weather")
class WeatherController(private val service: WeatherService) {

    @GetMapping
    fun getBanks(): Collection<Weather> = service.getWeathers()

    @GetMapping("/{city}")
    fun getWeatherByCity(@PathVariable city: String): Weather {
        return service.getWeatherByCity(city)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addWeather(@RequestBody weather: Weather) = service.addWeather(weather)

    @PatchMapping
    fun updateWeather(@RequestBody weather: Weather) = service.updateWeather(weather)

    @DeleteMapping
    fun deleteWeather(city: String) = service.deleteWeather(city)
}