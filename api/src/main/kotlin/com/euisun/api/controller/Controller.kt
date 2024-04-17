
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather")
class WeatherController(private val weatherApiService: WeatherAPIService) {

    @PostMapping("/forecast/update")
    fun updateForecast(): ResponseEntity<String> {
        weatherApiService.updateForecast()
        return ResponseEntity.ok("Forecast updated successfully.")
    }

    @GetMapping("/forecast")
    fun getForecast(): ResponseEntity<Any> {
        val forecast = weatherApiService.getForecast()
        return if (forecast != null) {
            ResponseEntity.ok(forecast)
        } else {
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(null)
        }
    }
}