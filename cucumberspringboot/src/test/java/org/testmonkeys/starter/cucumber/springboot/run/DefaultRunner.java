package org.testmonkeys.starter.cucumber.springboot.run;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(//src\test\resouces\features
        features = "src/test/resources/features/",
        glue= {"org.testmonkeys.starter.cucumber.springboot.steps",
                "org.testmonkeys.starter.cucumber.springboot.hooks"},
        plugin = {"json:target/cucumberReport.json"}
)
public class DefaultRunner {
}
