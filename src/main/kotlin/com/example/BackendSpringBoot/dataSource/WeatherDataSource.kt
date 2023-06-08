package com.example.BackendSpringBoot.dataSource

import com.example.BackendSpringBoot.models.Weather

interface WeatherDataSource {
    fun retrieveWeather(): Collection<Weather>
    fun retrieveWeather(city: String): Weather
    fun createNewWeather(weather: Weather): Weather
    fun updateWeather(weather: Weather): Weather
    fun deleteWeather(city: String)
}