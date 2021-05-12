package com.tech.gui.managers

import com.tech.gui.pages.CheckboxesPage
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
class CheckboxesManager {

    @Autowired
    private CheckboxesPage checkboxesPage

    void tickCheckbox(String num) {
        checkboxesPage.checkboxByNum(num).click()
    }

    boolean verifyIsChecked(boolean isCheckedFlag, List<String> list) {
        list.each ( {
            assert !(isCheckedFlag ^ checkboxesPage.isChecked(it))
        } )
    }
}
