package com.tech.gui.steps

import com.tech.gui.common.ConfigProvider
import com.tech.gui.common.ConfigProviderSingleton
import com.tech.gui.common.GuiBase
import cucumber.api.java.en.And
import cucumber.api.java.en.When
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired

import static com.codeborne.selenide.Selenide.open
import static com.codeborne.selenide.Selenide.refresh

@Slf4j
class NavigationSteps {

    @Autowired
    private GuiBase guiBase

    private ConfigProvider configProvider = ConfigProviderSingleton.instance

    @When("I navigate to (.*) page")
    void iNavigateToPage(String pagePath) {
        String path = configProvider.getBASE_URL() + "/" + pagePath
        log.info("navigate to path = $path")
        open(path)
        guiBase.waitForLoad()
    }

    @And("I refresh the page")
    void iRefreshThePage() {
        refresh()
        guiBase.waitForLoad()
    }
}
