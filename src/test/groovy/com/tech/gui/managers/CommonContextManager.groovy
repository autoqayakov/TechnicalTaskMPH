package com.tech.gui.managers

import io.restassured.response.Response
import org.springframework.stereotype.Component

@Component
class CommonContextManager {

    private Map<String, Object> contextObjects = [:]

    private Response contextResponse

    Object getContextObjects(String key) {
        return contextObjects.get(key)
    }

    void setContextObjects(String key, Object obj) {
        this.contextObjects.put(key, obj)
    }

    Response getContextResponse() {
        return contextResponse
    }

    void setContextResponse(Response contextResponse) {
        this.contextResponse = contextResponse
    }
}
