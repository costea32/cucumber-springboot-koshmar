package org.testmonkeys.starter.cucumber.springboot.builders;

import org.springframework.stereotype.Component;
import org.testmonkeys.starter.cucumber.springboot.model.Hobby;
import org.testmonkeys.starter.cucumber.springboot.model.UserData;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class UserBuilder {

    public UserData getRandomUser(){
        String timestamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        UserData user = new UserData();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.getHobbies().add(Hobby.Reading);
        user.setPhoneNumber("0123456789");
        user.setUsername("CukeDemo"+timestamp);
        user.setEmail("cukeDemo"+timestamp+"@demoNotExistingSite.hz");
        user.setPassword("Thi$15@Str00ngPa55w0rd!");
        user.setConfirmPassword("Thi$15@Str00ngPa55w0rd!");
//        user.setCountry("Bahamas");
//        user.setDateOfBirth(LocalDate.of(1987,2,15));

        return user;
    }

    public void removeField(UserData userData, String fieldName) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        BeanInfo info = Introspector.getBeanInfo(UserData.class);
        PropertyDescriptor[] pds = info.getPropertyDescriptors();

        for (PropertyDescriptor prop:pds){
            if (prop.getName().equalsIgnoreCase(fieldName.replaceAll(" ",""))){
                prop.getWriteMethod().invoke(userData,prop.getReadMethod().getDefaultValue());
            }
        }
    }
}
