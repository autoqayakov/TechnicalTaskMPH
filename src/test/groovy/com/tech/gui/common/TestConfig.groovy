package com.tech.gui.common

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan(basePackages = "com.tech")
@PropertySource("classpath:config.properties")
class TestConfig {

}
