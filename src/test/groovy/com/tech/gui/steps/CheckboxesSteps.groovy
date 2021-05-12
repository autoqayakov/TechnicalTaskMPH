package com.tech.gui.steps

import com.tech.gui.managers.CheckboxesManager
import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import groovy.util.logging.Slf4j
import io.cucumber.datatable.DataTable
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
class CheckboxesSteps {

    @Autowired
    private CheckboxesManager checkboxesManager

    @And("I tick checkboxes")
    void iTickCheckboxes(DataTable dataTable) {
        dataTable.asList().each ( { checkboxesManager.tickCheckbox(it) } )
    }

    @Then("I verify checkboxes state")
    void iVerifyCheckboxesState(DataTable dataTable) {
        List<String> checked = dataTable.asMaps().first().get("checked").split().toList()
        List<String> unchecked = dataTable.asMaps().first().get("unchecked").split().toList()
        checkboxesManager.verifyIsChecked(true, checked)
        checkboxesManager.verifyIsChecked(false, unchecked)
    }
}
