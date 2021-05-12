package com.tech.api.services

import groovy.util.logging.Slf4j
import io.restassured.response.Response
import org.springframework.stereotype.Component

@Slf4j
@Component
class WeatherService extends CommonService {

    Response getWeather(String cityName) {
        newRequest().get(BASE_URL + "/" + cityName)
    }

}
