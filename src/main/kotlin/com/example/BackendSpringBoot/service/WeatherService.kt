package com.example.BackendSpringBoot.service

import com.example.BackendSpringBoot.model.Weather
import com.example.BackendSpringBoot.model.WeatherForecastData
import com.example.BackendSpringBoot.repositories.WeatherRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate
import java.time.ZoneOffset

@Service
class WeatherService(private val weatherRepository: WeatherRepository) {
    private val openWeatherApiUrl = "https://api.openweathermap.org/data/2.5/forecast"
    private val openWeatherUnit = "metric"
    private val openWeatherLanguage = "ru"

    fun saveWeatherForecast(city: String) {
        val restTemplate = RestTemplate()
        val apiKey = "625b6fd5c5be3e9c809460446a1fd3e9"
        val url = "$openWeatherApiUrl?q=$city&appid=$apiKey&units=$openWeatherUnit&lang=$openWeatherLanguage"

        val weatherForecastData = restTemplate.getForObject(url, WeatherForecastData::class.java)

        print(weatherForecastData)

        weatherForecastData?.list?.forEach { forecastItem ->
            val datetime = forecastItem.dt * 1000L
            val existingWeather = weatherRepository.findByDatetimeAndCity(datetime, weatherForecastData.city.name)

            if (existingWeather == null) {
                val weather = Weather().apply {
                    this.datetime = datetime
                    this.city = weatherForecastData.city.name
                    max = forecastItem.main.temp_max
                    current = forecastItem.main.temp
                    min = forecastItem.main.temp_min
                    description = forecastItem.weather.getOrNull(0)?.description ?: ""
                    icon = forecastItem.weather.getOrNull(0)?.icon ?: ""
                    windSpeed = forecastItem.wind.speed
                    windDeg = forecastItem.wind.deg
                    dtTxt = forecastItem.dt_txt
                }

                weatherRepository.save(weather)
            }
        }
    }

    fun getWeatherForToday(city: String): List<Weather>? {
        val today = LocalDate.now()
        val startOfDay = today.atStartOfDay()
        val endOfDay = today.plusDays(3).atTime(23, 59, 59)
        val startOfDayEpoch = startOfDay.toEpochSecond(ZoneOffset.UTC) * 1000
        val endOfDayEpoch = endOfDay.toEpochSecond(ZoneOffset.UTC) * 1000
        println(startOfDayEpoch)
        println(endOfDayEpoch)
        return weatherRepository.findByDatetimeBetweenAndCity(startOfDayEpoch, endOfDayEpoch, city)
    }
}