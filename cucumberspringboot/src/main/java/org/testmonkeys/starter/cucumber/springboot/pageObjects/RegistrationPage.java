package org.testmonkeys.starter.cucumber.springboot.pageObjects;

import org.testmonkeys.koshmar.pageobjects.AbstractPage;
import org.testmonkeys.koshmar.pageobjects.ElementAccessor;
import org.testmonkeys.koshmar.pageobjects.PageAccessor;
import org.testmonkeys.koshmar.pageobjects.elements.Button;
import org.testmonkeys.koshmar.pageobjects.elements.CheckBoxButtonGroup;
import org.testmonkeys.koshmar.pageobjects.elements.Input;
import org.testmonkeys.koshmar.pageobjects.elements.Label;
import org.testmonkeys.koshmar.pageobjects.elements.html.HtmlElement;
import org.testmonkeys.starter.cucumber.springboot.elements.ValidatedCheckBoxButtonGroup;
import org.testmonkeys.starter.cucumber.springboot.elements.ValidatedInput;

@PageAccessor(name = "Registration", url = "/registration/")
public class RegistrationPage extends AbstractPage {

    @ElementAccessor(elementName = "firstName", byId = "name_3_firstname")
    private ValidatedInput firstName;

    @ElementAccessor(elementName = "lastName", byId = "name_3_lastname")
    private Input lastName;

    @ElementAccessor(elementName = "Submit", byName = "pie_submit")
    private Button submit;

    @ElementAccessor(elementName = "Hobbies", byName = "checkbox_5[]")
    private ValidatedCheckBoxButtonGroup hobbies;

    @ElementAccessor(elementName="PhoneNumber",byId = "phone_9")
    private Input phoneNumber;

    @ElementAccessor(elementName="UserName",byId = "username")
    private ValidatedInput userName;

    @ElementAccessor(elementName="Email",byId = "email_1")
    private Input email;

    @ElementAccessor(elementName="Password",byId = "password_2")
    private Input password;

    @ElementAccessor(elementName="ConfirmPassword",byId = "confirm_password_password_2")
    private Input confirmPassword;

    @ElementAccessor(elementName="SubmitMessage",byClassName = "piereg_message")
    private Label submitMessage;

    public ValidatedInput firstName() {
        return firstName;
    }

    public Input lastName() {
        return lastName;
    }

    public ValidatedCheckBoxButtonGroup hobbies() {
        return hobbies;
    }

    public Input phoneNumber(){
        return phoneNumber;
    }

    public ValidatedInput userName() {
        return userName;
    }

    public Input email() {
        return email;
    }

    public Input password(){
        return password;
    }

    public Input confirmPassword(){
        return confirmPassword;
    }

    public Button submit() {
        return submit;
    }

    public Label submitMessage() {
        return submitMessage;
    }
}
