package com.example.BackendSpringBoot.mock

import com.example.BackendSpringBoot.dataSource.WeatherDataSource
import com.example.BackendSpringBoot.models.Weather
import org.springframework.stereotype.Component

@Component
class MockWeatherDataSource: WeatherDataSource {
    private val weathers = listOf(
        Weather("Kemerovo", 22.0, 35.00, 30.00),
        Weather("Novokuznetsk", 24.0, 37.00, 32.00),
        Weather("Topki", 21.0, 33.00, 29.00),
    )
    override fun retrieveWeather(): Collection<Weather> = weathers
}