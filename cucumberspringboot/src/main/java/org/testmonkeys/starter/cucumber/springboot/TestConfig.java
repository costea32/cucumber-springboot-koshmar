package org.testmonkeys.starter.cucumber.springboot;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.koshmar.core.browser.DriverFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@PropertySource(
        value = {"file:properties/driver.properties"},
        ignoreResourceNotFound = true)
public class TestConfig {
    @Bean
    @Scope("prototype")
    public WebDriver webDriver(@Value("${browser}") String browser,
                               @Value("${browser.mode}") String mode) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("properties/driver.properties"));

        DesiredCapabilities capabilities = new DesiredCapabilities(browser, "", Platform.ANY);
        for (Object key : properties.keySet()) {
            capabilities.setCapability(String.valueOf(key), properties.getProperty(String.valueOf(key)));
        }

        return DriverFactory.initDriver(browser, mode, capabilities);
    }

    @Bean
    @Scope("prototype")
    public Browser browser(WebDriver webDriver,
                           @Value("${browser.timeout.unit}") TimeUnit unit,
                           @Value("${browser.element.timeout}") int elementTimeout,
                           @Value("${browser.page.timeout}") int pageTimeout) {
        return new Browser(webDriver, unit, elementTimeout, pageTimeout);
    }
}
