package com.grayzemon.systemtest.hooks;

import com.grayzemon.systemtest.utils.DriverUtils;
import com.grayzemon.systemtest.utils.Screenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;

import java.io.IOException;

public class AfterHooks {

    @After()
    public void afterRunningScenario(Scenario scenario)  {
        //Screenshot.takeScreenshotAfterEveryScenario(scenario);
    }

    @After(order = 100)
    public void afterRunningScenario3() {
        DriverUtils.closeDriver();
    }

}