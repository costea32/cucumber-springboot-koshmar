package org.testmonkeys.starter.cucumber.springboot;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.function.Consumer;

@Component
public class ScenarioLogger extends AppenderBase<ILoggingEvent> {

    @Autowired
    private ScenarioContext scenarioContext;

    @Override
    protected void append(ILoggingEvent event) {
        if (scenarioContext==null || scenarioContext.getCucumberScenario()==null)
            return;
        scenarioContext.getCucumberScenario().write(event.getMessage());
    }

    @PostConstruct
    public void init() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.getLoggerList().forEach(new Consumer<Logger>() {

            @Override
            public void accept(Logger logger) {
                if (logger.getName().equalsIgnoreCase("ROOT")) {
                    logger.addAppender(ScenarioLogger.this);
                }
            }
        });

        setContext(context);
        start();
    }

}
