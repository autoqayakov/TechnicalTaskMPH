package com.tech.api.models

import com.fasterxml.jackson.annotation.JsonProperty

class DayForecast {

    @JsonProperty("day")
    String day

    @JsonProperty("temperature")
    String temperature

    @JsonProperty("wind")
    String wind
}
