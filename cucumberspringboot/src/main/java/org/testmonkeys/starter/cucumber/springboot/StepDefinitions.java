package org.testmonkeys.starter.cucumber.springboot;

import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = {Application.class, TestConfig.class}, loader = SpringBootContextLoader.class)
public @interface StepDefinitions {
}
