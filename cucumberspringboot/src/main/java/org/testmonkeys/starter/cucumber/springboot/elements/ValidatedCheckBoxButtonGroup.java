package org.testmonkeys.starter.cucumber.springboot.elements;

import org.testmonkeys.koshmar.core.elements.location.Locator;
import org.testmonkeys.koshmar.core.elements.location.LocatorType;
import org.testmonkeys.koshmar.pageobjects.elements.CheckBoxButtonGroup;
import org.testmonkeys.koshmar.pageobjects.elements.Input;

public class ValidatedCheckBoxButtonGroup extends CheckBoxButtonGroup implements ValidatedControl {
//
////    @Override
////    public boolean hasValidationError() {
////        try{
////            return this.findElementInContainer(new Locator(LocatorType.XPath,
////                    "ancestor::div[@class='fieldset error']//span[@class='legend error']")).isDisplayed();
////        }catch(Throwable e){}
////        return false;
////    }
////
////    @Override
////    public String getErrorText() {
////        try{
////            return this.findElementInContainer(new Locator(LocatorType.XPath,
////                    "ancestor::div[@class='fieldset error']//span[@class='legend error']")).getText();
////        }catch(Throwable e){}
////        return null;
////    }
}
