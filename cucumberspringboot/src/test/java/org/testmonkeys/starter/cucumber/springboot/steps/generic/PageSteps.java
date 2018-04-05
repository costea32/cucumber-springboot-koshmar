package org.testmonkeys.starter.cucumber.springboot.steps.generic;

import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.testmonkeys.starter.cucumber.springboot.ScenarioContext;
import org.testmonkeys.starter.cucumber.springboot.StepDefinitions;

@StepDefinitions
public class PageSteps {

    @Autowired
    private ScenarioContext scenarioContext;

    @Given("the user is on (.*)(?: page)")
    public void userIsOnPage(String pageName){

        scenarioContext.getPageFactory().createPage(pageName).open();
    }

}
