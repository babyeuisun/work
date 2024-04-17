package com.euisun.domain.repository
import com.euisun.domain.domain.WeatherInfo
import org.springframework.data.jpa.repository.JpaRepository

interface WeatherInfoRepository : JpaRepository<WeatherInfo, Long> {
    fun findTopByOrderByCreatedAtDesc(): WeatherInfo?
}