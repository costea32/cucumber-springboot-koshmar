package org.testmonkeys.starter.cucumber.springboot.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testmonkeys.koshmar.core.browser.Browser;
import org.testmonkeys.starter.cucumber.springboot.ScenarioContext;
import org.testmonkeys.starter.cucumber.springboot.StepDefinitions;
import org.testmonkeys.starter.cucumber.springboot.actions.RegistrationActions;
import org.testmonkeys.starter.cucumber.springboot.builders.UserBuilder;
import org.testmonkeys.starter.cucumber.springboot.elements.ValidatedControl;
import org.testmonkeys.starter.cucumber.springboot.model.UserData;
import org.testmonkeys.starter.cucumber.springboot.pageObjects.RegistrationPage;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.core.Is.is;
import static org.testmonkeys.starter.cucumber.springboot.dataKeys.Registration.*;
import static org.testmonkeys.starter.cucumber.springboot.CustomAssert.*;

@StepDefinitions
public class RegistrationSteps {

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private UserBuilder userBuilder;

    @Autowired
    private RegistrationActions registrationActions;

    @Given("(?:he|the user) has the registration details")
    public void registrationDetailsCreation(){

        scenarioContext.getData().add(UserData,userBuilder.getRandomUser());
    }

    @Given("(?:he|the user) is lacking (.*)")
    public void userDataLacking(String fieldName) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        UserData userData=scenarioContext.getData().get(UserData);
        userBuilder.removeField(userData, fieldName);
    }

    @When("the user fills in the registration page")
    public void userFillsRegistrationPage() {
        RegistrationPage page=scenarioContext.getPageFactory().createPage(RegistrationPage.class);
        UserData userData=scenarioContext.getData().get(UserData);
        registrationActions.fillRegistrationPage(userData, page);
    }

    @When("(?:he|the user) submits the registration details")
    public void userSubmitsRegsitrationDetails(){
        RegistrationPage page=scenarioContext.getPageFactory().createPage(RegistrationPage.class);
        page.submit().click();
    }

    @Then("(?:he|the user) should see a success message")
    public void successMessageDisplayed(){
        RegistrationPage page=scenarioContext.getPageFactory().createPage(RegistrationPage.class);
        String successMessage=page.submitMessage().getText();
        assertThat(successMessage,is("Thank you for your registration"));
    }
    @Then("(?:he|the user) should see an error message for (.*) field with message: (.*)")
    public void errorMessageDisplayed(String fieldName, String errorMessage){
        RegistrationPage page=scenarioContext.getPageFactory().createPage(RegistrationPage.class);
        ValidatedControl validatedControl=scenarioContext.getPageFactory().getElement(page,fieldName);
        assertThat("Error message present",validatedControl.hasValidationError(),is(true));
        assertThat("Error message",validatedControl.getErrorText(),is(errorMessage));
    }


}
