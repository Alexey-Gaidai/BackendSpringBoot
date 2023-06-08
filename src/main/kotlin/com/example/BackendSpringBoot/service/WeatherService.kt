package com.example.BackendSpringBoot.service

import com.example.BackendSpringBoot.dataSource.WeatherDataSource
import com.example.BackendSpringBoot.models.Weather
import org.springframework.instrument.classloading.WeavingTransformer
import org.springframework.stereotype.Service

@Service
class WeatherService(private val dataSource: WeatherDataSource) {
    fun getWeathers(): Collection<Weather> =  dataSource.retrieveWeather()
    fun getWeatherByCity(city: String): Weather = dataSource.retrieveWeather(city)
    fun addWeather(weather: Weather): Weather = dataSource.createNewWeather(weather)
    fun updateWeather(weather: Weather): Weather = dataSource.updateWeather(weather)
    fun deleteWeather(city: String) = dataSource.deleteWeather(city)
}