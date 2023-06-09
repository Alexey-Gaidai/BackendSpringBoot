package com.example.BackendSpringBoot.model

data class Weather(
    val city: String,
    val min: Double,
    val max: Double,
    val current: Double
)
