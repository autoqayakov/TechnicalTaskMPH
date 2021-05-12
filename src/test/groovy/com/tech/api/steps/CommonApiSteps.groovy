package com.tech.api.steps

import com.tech.gui.managers.CommonContextManager
import cucumber.api.java.en.Then
import io.restassured.response.Response
import org.springframework.beans.factory.annotation.Autowired

class CommonApiSteps {

    @Autowired
    private CommonContextManager commonContextManager

    @Then("I verify response status is {int}")
    void iGETArticlesWithLimit(int status) {
        Response response = commonContextManager.getContextResponse()
        response.then().assertThat().statusCode(status)
        commonContextManager.setContextResponse(response)
    }
}
