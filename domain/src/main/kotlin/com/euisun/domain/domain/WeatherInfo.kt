package com.euisun.domain.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class WeatherInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val temperature: Double,
    val humidity: Double,
    val description: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
)