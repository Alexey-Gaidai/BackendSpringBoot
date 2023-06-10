package com.example.BackendSpringBoot.mock

import com.example.BackendSpringBoot.dataSource.WeatherDataSource
import com.example.BackendSpringBoot.model.Weather
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.ZoneOffset

@Component
class MockWeatherDataSource: WeatherDataSource {
    private val weathers = createMockWeatherList()
    private final fun createMockWeatherList(): MutableList<Weather> {
        val weatherList = mutableListOf<Weather>()

        val weather1 = Weather().apply {
            datetime = LocalDateTime.now().minusDays(1).toEpochSecond(ZoneOffset.UTC) * 1000
            city = "City1"
            max = 25.0
            min = 20.0
            description = "Sunny"
            icon = "01d"
            windSpeed = 10.0
            windDeg = 180
        }
        weatherList.add(weather1)

        val weather2 = Weather().apply {
            datetime = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) * 1000
            city = "City1"
            max = 28.0
            min = 22.0
            description = "Cloudy"
            icon = "02d"
            windSpeed = 12.0
            windDeg = 200
        }
        weatherList.add(weather2)

        val weather3 = Weather().apply {
            datetime = LocalDateTime.now().plusDays(1).toEpochSecond(ZoneOffset.UTC) * 1000
            city = "City2"
            max = 22.0
            min = 18.0
            description = "Rainy"
            icon = "10d"
            windSpeed = 8.0
            windDeg = 220
        }
        weatherList.add(weather3)

        return weatherList
    }

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