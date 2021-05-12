package com.tech.gui.hooks

import com.tech.gui.common.ConfigProvider
import com.tech.gui.common.ConfigProviderSingleton
import com.tech.gui.common.GuiBase
import com.tech.gui.common.TestConfig
import cucumber.api.java.Before
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = TestConfig)
class GuiHooks {

    private ConfigProvider configProvider = ConfigProviderSingleton.instance

    private GuiBase guiBase = new GuiBase()

    @Before(value = "@GuiTest", order = 0)
    void beforeGui() {
        guiBase.setupBrowser()
        guiBase.openBaseUrl()
    }
}
