package com.example.BackendSpringBoot

import com.example.BackendSpringBoot.dataSource.WeatherDataSource
import com.example.BackendSpringBoot.service.WeatherService
import org.junit.jupiter.api.Test
import io.mockk.mockk
import io.mockk.verify

class WeatherServiceTest {
    private val dataSource: WeatherDataSource = mockk(relaxed = true)
    private val weatherService = WeatherService(dataSource)
    @Test
    fun `should call its data source to retrieve banks`() {
        //given

        //when
        weatherService.getBanks()
        verify(exactly = 1) { dataSource.retrieveWeather() }
        //then

    }
}