package org.testmonkeys.starter.cucumber.springboot.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.elements.actions.ActionHooksContext;
import org.testmonkeys.koshmar.core.factory.PageFactory;
import org.testmonkeys.koshmar.core.factory.PageScanner;
import org.testmonkeys.starter.cucumber.springboot.ScenarioContext;
import org.testmonkeys.starter.cucumber.springboot.StepDefinitions;

@StepDefinitions
public class WebHooks {

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private ApplicationContext context;

    @Before("@Web")
    public void webInit(){
        scenarioContext.setBrowser(context.getBean(Browser.class));
        scenarioContext.setPageFactory(new PageFactory(scenarioContext.getBrowser(),
                new PageScanner("org.testmonkeys.starter.cucumber.springboot.pageObjects"),
                "http://demoqa.com"));

        //ActionHooksContext.getContext().registerBeforeHook();
    }

    @After("@Web")
    public void webCleanup(){
        scenarioContext.getBrowser().quit();
    }
}
