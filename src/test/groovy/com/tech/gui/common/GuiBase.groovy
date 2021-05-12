package com.tech.gui.common

import com.codeborne.selenide.WebDriverProvider
import com.codeborne.selenide.WebDriverRunner
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import org.springframework.stereotype.Component

import static com.codeborne.selenide.Configuration.browser
import static com.codeborne.selenide.Selenide.open
import static com.codeborne.selenide.Selenide.sleep

@Component
class GuiBase {

    private ConfigProvider configProvider = ConfigProviderSingleton.instance

    void setupBrowser() {
        String envWebDriver = configProvider.getDRIVER()

        switch (envWebDriver) {
            case "chrome":
                browser = "com.tech.gui.common.ChromeDriverProvider"
                break
            default:
                throw new RuntimeException("driver is unknown:" + envWebDriver)
        }
    }

    void openBaseUrl() {
        open(configProvider.BASE_URL)
        waitForLoad()
    }

    static void waitForLoad() {
        WebDriver driver = WebDriverRunner.getWebDriver()
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) { wd ->
            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        })
    }
}

class ChromeDriverProvider implements WebDriverProvider {

    @Override
    WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        WebDriverManager.chromedriver().setup()
        ChromeOptions options = new ChromeOptions()
        options.with {
            addArguments("--no-sandbox")
            addArguments("--disable-web-security")
        }
        new ChromeDriver(options)
    }
}
