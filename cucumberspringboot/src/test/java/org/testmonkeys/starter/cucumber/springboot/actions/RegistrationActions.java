package org.testmonkeys.starter.cucumber.springboot.actions;

import org.springframework.stereotype.Component;
import org.testmonkeys.starter.cucumber.springboot.model.Hobby;
import org.testmonkeys.starter.cucumber.springboot.model.UserData;
import org.testmonkeys.starter.cucumber.springboot.pageObjects.RegistrationPage;

import java.util.Set;

@Component
public class RegistrationActions {

    private boolean hasValue(String string){
        return string!=null && !string.isEmpty();
    }

    private boolean hasValue(Set set){
        return set!=null && !set.isEmpty();
    }

    public void fillRegistrationPage(UserData data, RegistrationPage page){
        if (hasValue(data.getFirstName()))
            page.firstName().type(data.getFirstName());
        if (hasValue(data.getLastName()))
            page.lastName().type(data.getLastName());
        if (hasValue(data.getHobbies())){
            for (Hobby hobby:data.getHobbies()){
                page.hobbies().selectByValue(hobby.toString());
            }
        }
        if (hasValue(data.getPhoneNumber()))
            page.phoneNumber().type(data.getPhoneNumber());
        if (hasValue(data.getUsername()))
            page.userName().type(data.getUsername());
        if (hasValue(data.getEmail()))
            page.email().type(data.getEmail());
        if (hasValue(data.getPassword()))
            page.password().type(data.getPassword());
        if (hasValue(data.getConfirmPassword()))
            page.confirmPassword().type(data.getConfirmPassword());
    }
}
