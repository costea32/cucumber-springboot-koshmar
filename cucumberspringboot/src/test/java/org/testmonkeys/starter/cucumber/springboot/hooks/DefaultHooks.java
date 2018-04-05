package org.testmonkeys.starter.cucumber.springboot.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.testmonkeys.starter.cucumber.springboot.ScenarioContext;
import org.testmonkeys.starter.cucumber.springboot.StepDefinitions;

@StepDefinitions
public class DefaultHooks {

    @Autowired
    private ScenarioContext scenarioContext;

    @Before
    public void init(Scenario scenario){
        scenarioContext.setCucumberScenario(scenario);
    }
}
