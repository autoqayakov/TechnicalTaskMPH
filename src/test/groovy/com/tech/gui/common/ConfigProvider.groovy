package com.tech.gui.common

import groovy.util.logging.Slf4j

@Singleton
class ConfigProviderSingleton extends ConfigProvider {}

@Slf4j
class ConfigProvider {
    Properties configProperties = initProperties()
    final String DRIVER = getProp("driver")
    final String BASE_URL = getProp("base.url")
    final String ADMIN_LOGIN = getProp("admin.login")
    final String ADMIN_PASSWORD = getProp("admin.password")

    Properties initProperties() {
        if (configProperties == null) {
            configProperties = new Properties()
            File propsFile = new File("src/test/resources/config.properties")
            configProperties.load(propsFile.newDataInputStream())
        }
        configProperties
    }

    String getProp(String propertyName) {
        configProperties.getProperty(propertyName)
    }
}
