package com.example.BackendSpringBoot.mock

import com.example.BackendSpringBoot.dataSource.WeatherDataSource
import com.example.BackendSpringBoot.model.Weather
import org.springframework.stereotype.Component

@Component
class MockWeatherDataSource: WeatherDataSource {
    private val weathers = mutableListOf(
        Weather("Kemerovo", 22.0, 35.00, 30.00),
        Weather("Novokuznetsk", 24.0, 37.00, 32.00),
        Weather("Topki", 21.0, 33.00, 29.00),
    )
    override fun retrieveWeather(): Collection<Weather> = weathers
    override fun retrieveWeather(city: String): Weather =
        weathers.firstOrNull { it.city == city } ?: throw NoSuchElementException("Could not find city named $city")

    override fun createNewWeather(weather: Weather): Weather {
        if (weathers.any { it.city == weather.city }) {
            throw IllegalArgumentException("Weather for city ${weather.city} already exists")
        }
        weathers.add(weather)
        return weather
    }

    override fun updateWeather(weather: Weather): Weather {
        val currentWeather = weathers.firstOrNull { it.city == weather.city }
            ?: throw NoSuchElementException("Could not find city with named ${weather.city}")

        weathers.remove(currentWeather)
        weathers.add(weather)

        return weather
    }

    override fun deleteWeather(city: String){
        val currentWeather =
            weathers.firstOrNull { it.city == city } ?: throw NoSuchElementException("Could not find city with named $city")

        weathers.remove(currentWeather)

    }


}