package com.tech.api.models

import com.fasterxml.jackson.annotation.JsonProperty

class Forecast {

    @JsonProperty("temperature")
    String temperature

    @JsonProperty("wind")
    String wind

    @JsonProperty("description")
    String description

    @JsonProperty("forecast")
    List<DayForecast>forecast

}
