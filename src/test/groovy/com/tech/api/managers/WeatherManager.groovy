package com.tech.api.managers

import com.tech.api.models.Forecast
import com.tech.api.services.WeatherService
import com.tech.gui.managers.CommonContextManager
import groovy.util.logging.Slf4j
import io.restassured.response.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
class WeatherManager {

    @Autowired
    private WeatherService weatherService

    @Autowired
    private CommonContextManager commonContextManager

    Forecast getWeather(String cityName) {
        log.info("executing weather request to city=$cityName")
        Response response = weatherService.getWeather(cityName)
        commonContextManager.setContextResponse(response)
        response.as(Forecast)
    }

}
