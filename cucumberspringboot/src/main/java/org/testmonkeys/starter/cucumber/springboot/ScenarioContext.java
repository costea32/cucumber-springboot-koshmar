package org.testmonkeys.starter.cucumber.springboot;

import cucumber.api.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.factory.PageFactory;

@Component
public class ScenarioContext {

    private Browser browser;
    private PageFactory pageFactory;
    private Scenario cucumberScenario;

    @Autowired
    private DataDictionary data;

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void setPageFactory(PageFactory pageFactory) {
        this.pageFactory = pageFactory;
    }

    public PageFactory getPageFactory() {
        return pageFactory;
    }

    public Scenario getCucumberScenario() {
        return cucumberScenario;
    }

    public void setCucumberScenario(Scenario cucumberScenario) {
        this.cucumberScenario = cucumberScenario;
    }

    public DataDictionary getData() {
        return data;
    }

    public void setData(DataDictionary data) {
        this.data = data;
    }
}
