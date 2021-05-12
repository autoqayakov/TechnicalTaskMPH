package com.tech.api.steps

import com.tech.api.managers.WeatherManager
import com.tech.api.models.Forecast
import com.tech.gui.managers.CommonContextManager
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

import static com.tech.utils.Consts.FORECAST

@Slf4j
class ApiWeatherSteps {

    @Autowired
    private WeatherManager weatherManager

    @Autowired
    private CommonContextManager commonContextManager

    @When("I execute weather request to (.*) city")
    void iExecuteWeatherRequestToCity(String cityName) {
        Forecast forecast = weatherManager.getWeather(cityName)
        commonContextManager.setContextObjects(FORECAST, forecast)
    }

    @Then(/^I verify that (.*) property (isNot|is) empty$/)
    void iVerifyThatPropertyIsNotEmpty(String propertyName, String isOrIsNot) {
        Forecast forecast = (Forecast) commonContextManager.getContextObjects(FORECAST)
        String propertyValue = forecast.getProperty(propertyName)
        if (isOrIsNot == "isNot") {
            assert propertyValue != ""
        } else {
            assert propertyValue == ""
        }
    }

    @Then("I verify that temperature is more than (.*) and less than (.*)")
    void iVerifyThatTemperatureIsMoreThanAndLessThan(String lowerLimit, String upperLimit) {
        Forecast forecast = (Forecast) commonContextManager.getContextObjects(FORECAST)
        String propertyValue = forecast.getProperty("temperature")
        int parsedTemperature = Integer.parseInt(propertyValue.find("(.*)(?= °C)"))
        log.info("verify that temperature $parsedTemperature is within range [$lowerLimit, $upperLimit]")
        assert (parsedTemperature > Integer.parseInt(lowerLimit)) && (parsedTemperature < Integer.parseInt(upperLimit))
    }
}
