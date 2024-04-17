package com.euisun.domain.service
data class WeatherResponse(
    val main: Main,
    val weather: List<WeatherInformation>
)

data class Main(
    val temp: Double,
    val humidity: Double
)

data class WeatherInformation(
    val description: String
) {
}