package com.example.BackendSpringBoot

import com.example.BackendSpringBoot.mock.MockWeatherDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BackendSpringBootApplicationTests {

	private val dataSource = MockWeatherDataSource()
	@Test 
	fun `should provide a collection of Weather`() {
	    //when 
	    val banks = dataSource.retrieveWeather()
	    
	    //then
		assertThat(banks.size).isGreaterThanOrEqualTo(3)
	}

	@Test
	fun `should provide some mock data`() {
		//when
		val weathers = dataSource.retrieveWeather()

		//then
		assertThat(weathers).allMatch{it.city.isNotBlank()}//all match - удовлетворяют все условия
		assertThat(weathers).anyMatch{it.min != 0.0}//any match - удовлетворяет хотя бы одно
		assertThat(weathers).allMatch{it.max != 0.0}
	}
}
