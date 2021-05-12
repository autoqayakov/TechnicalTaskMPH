package com.tech.api.services

import groovy.util.logging.Slf4j
import io.restassured.RestAssured
import io.restassured.specification.RequestSpecification

@Slf4j
class CommonService {

    protected static final String BASE_URL = "https://goweather.herokuapp.com/weather"

    static RequestSpecification newRequest() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
        RestAssured.given().relaxedHTTPSValidation()
    }
}
