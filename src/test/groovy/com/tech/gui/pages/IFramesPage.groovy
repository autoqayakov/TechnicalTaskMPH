package com.tech.gui.pages

import com.codeborne.selenide.WebDriverRunner
import groovy.util.logging.Slf4j
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.springframework.stereotype.Component

@Slf4j
@Component
class IFramesPage {

    final String IFRAME = "//iframe"

    WebElement getIFrame(WebDriver driver) {
        driver.findElement(By.xpath(IFRAME))
    }

    WebElement getTextFieldFrame(WebDriver driver) {
        driver.findElement(By.xpath("//body//p"))
    }

    WebElement getTextFieldFrameWithText(WebDriver driver, String text) {
        driver.findElement(By.xpath("//body//p[text()='$text']"))
    }

}
