package com.tech.gui;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

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

class CucumberRunner extends AbstractTestNGCucumberTests {
}
