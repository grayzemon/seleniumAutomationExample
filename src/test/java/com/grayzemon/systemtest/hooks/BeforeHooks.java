package com.grayzemon.systemtest.hooks;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import static com.grayzemon.systemtest.utils.LoggingFactory.log;

public class BeforeHooks {

    public static Scenario scenario;
    public static String scenarioName;

    @Before()
    public void beforeCallingEveryScenario(Scenario scenario)
    {
        BeforeHooks.scenario = scenario;
        scenarioName = scenario.getName();
        log.info("Scenario ID: " + scenario.getId());
        //System.out.println("***********Executed before every Scenario*******");
    }
}