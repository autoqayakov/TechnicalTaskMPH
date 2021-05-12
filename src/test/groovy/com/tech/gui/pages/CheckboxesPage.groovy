package com.tech.gui.pages

import com.codeborne.selenide.SelenideElement
import groovy.util.logging.Slf4j
import org.springframework.stereotype.Component

import static com.codeborne.selenide.Selenide.$x

@Slf4j
@Component
class CheckboxesPage {

    SelenideElement checkboxByNum(String checkboxNum) {
        String xpath = "(//input[@type='checkbox'])[$checkboxNum]"
        $x(xpath)
    }

    boolean isChecked(String num) {
        String xpath = "(//input[@type='checkbox'])[$num][@checked]"
        $x(xpath).isDisplayed()
    }

}
