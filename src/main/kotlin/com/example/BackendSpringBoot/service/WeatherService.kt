package com.example.BackendSpringBoot.service

import com.example.BackendSpringBoot.dataSource.WeatherDataSource
import com.example.BackendSpringBoot.models.Weather
import org.springframework.stereotype.Service

@Service
class WeatherService(private val dataSource: WeatherDataSource) {
    fun getBanks(): Collection<Weather> =  dataSource.retrieveWeather()
}