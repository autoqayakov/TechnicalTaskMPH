package com.tech.gui.steps

import com.tech.gui.managers.CommonContextManager
import com.tech.gui.managers.IFramesManager
import com.tech.gui.pages.IFramesPage
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import groovy.util.logging.Slf4j
import org.openqa.selenium.WebDriver
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
class IFramesSteps {

    @Autowired
    private IFramesManager iFramesManager

    @Autowired
    private CommonContextManager commonContextManager

    @And("I type name (.*) inside iframe")
    void iTypeNameInsideIframe(String name) {
        WebDriver driver = iFramesManager.switchToIFrame()
        commonContextManager.setContextObjects(["driver":driver])
        iFramesManager.clearAndSetIFrameTextField(driver, name)
    }

    @Then("I verify that name (.*) is shown")
    void iVerifyThatNameIsShown(String name) {
        WebDriver driver = (WebDriver) commonContextManager.getContextObjects().get("driver")
        assert iFramesManager.verifyIframeTextField(driver, name)
        iFramesManager.switchToDefaultFrame()
    }
}
