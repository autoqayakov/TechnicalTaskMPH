package com.tech.api;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/groovy/com/tech/api"
        },
        glue = {
                "com/tech/api"
        },
        tags = {"not @Ignore", "not @Bug"},
        plugin = {
                "pretty"
        }
)

//todo - implement runner with TestNG, to run group of tests and Allure reporting also
public class CucumberRunner {
}
