package org.testmonkeys.starter.cucumber.springboot.elements;

import org.testmonkeys.koshmar.core.elements.Component;
import org.testmonkeys.koshmar.core.elements.location.Locator;
import org.testmonkeys.koshmar.core.elements.location.LocatorType;
import org.testmonkeys.koshmar.core.factory.PageInitializer;
import org.testmonkeys.koshmar.pageobjects.elements.Label;

public interface ValidatedControl extends Component {

    default Label errorLabel() {
        PageInitializer initializer = new PageInitializer();
        return (Label) initializer.createComponent(this.getBrowser(), Label.class, this,
                new Locator(LocatorType.XPath,
                        "ancestor::div[@class='fieldset error']//span[@class='legend error']"), "errorLabel");
    }

    default boolean hasValidationError() {


        try {
            errorLabel().getText();
            return true;
//                    this.findElement(new Locator(LocatorType.XPath,
//                    "ancestor::div[@class='fieldset error']//span[@class='legend error']")).isDisplayed();
        } catch (Throwable e) {
        }
        return false;
    }

    default String getErrorText() {
        try {
            return errorLabel().getText();
//                    this.findElement(new Locator(LocatorType.XPath,
//                    "ancestor::div[@class='fieldset error']//span[@class='legend error']")).getText();
        } catch (Throwable e) {
        }
        return null;
    }
}
