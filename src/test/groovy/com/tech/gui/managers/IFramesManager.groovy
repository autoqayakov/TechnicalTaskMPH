package com.tech.gui.managers

import com.codeborne.selenide.WebDriverRunner
import com.tech.gui.pages.IFramesPage
import groovy.util.logging.Slf4j
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
class IFramesManager {

    @Autowired
    private IFramesPage iFramesPage

    WebDriver switchToIFrame() {
        WebDriver driver = WebDriverRunner.getWebDriver()
        WebElement iframe = iFramesPage.getIFrame(driver)
        driver.switchTo().frame(iframe)
        driver
    }

    void switchToDefaultFrame() {
        WebDriver driver = WebDriverRunner.getWebDriver()
        driver.switchTo().defaultContent()
    }

    void clearAndSetIFrameTextField(WebDriver driver, String name) {
        iFramesPage.getTextFieldFrame(driver).clear()
        iFramesPage.getTextFieldFrame(driver).sendKeys(name)
    }

    boolean verifyIframeTextField(WebDriver driver, String name) {
        iFramesPage.getTextFieldFrameWithText(driver, name).displayed
    }
}
