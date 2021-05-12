package com.tech.gui;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/groovy/com/tech/gui"
        },
        glue = {
                "com/tech/gui/hooks",
                "com/tech/gui"
        },
        tags = {"not @Ignore", "not @Bug"},
        plugin = {
                "pretty"
        }
)

//todo - implement runner with TestNG, to run group of tests and Allure reporting also
public class CucumberRunner {
}
