package com.example.BackendSpringBoot.dataSource

import com.example.BackendSpringBoot.models.Weather

interface WeatherDataSource {
    fun retrieveWeather(): Collection<Weather>
}