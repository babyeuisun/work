import com.euisun.domain.domain.WeatherInfo
import com.euisun.domain.repository.WeatherInfoRepository
import com.euisun.domain.service.WeatherResponse
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder@Service
class WeatherAPIService(
    private val weatherInfoRepository: WeatherInfoRepository,
    private val restTemplate: RestTemplate
) {

    private val apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0"

    private val apiKey = "9cnQiyBmAKY5r86SCeMceLunUBsrSIXO9T5J7AWC9vHUNHXM0fDKLiZib8XhQy2lhPrHuSdOB%2FKNJzj1sA1O4A%3D%3D"

    fun updateForecast() {
        val response = restTemplate.getForObject("$apiUrl?serviceKey=$apiKey&dataType=JSON&base_date=20220101&base_time=0500&nx=60&ny=127", WeatherResponse::class.java)

        // 예보 데이터를 저장하는 로직 구현
        if (response != null) {
            val weather = WeatherInfo(
                temperature = response.main.temp,
                humidity = response.main.humidity,
                description = response.weather[0].description
            )
            weatherInfoRepository.save(weather)
        }
    }

    fun getForecast(): WeatherInfo? {
        return weatherInfoRepository.findTopByOrderByCreatedAtDesc()
    }
}