package com.grayzemon.systemtest.hooks;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import static com.grayzemon.systemtest.utils.LoggingFactory.log;

public class BeforeHooks {

    @Before()
    public void beforeCallingEveryScenario(Scenario scenario)
    {
        log.info("Scenario ID: " + scenario.getId());
    }
}