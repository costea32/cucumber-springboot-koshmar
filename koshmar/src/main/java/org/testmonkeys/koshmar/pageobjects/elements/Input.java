package org.testmonkeys.koshmar.pageobjects.elements;

import org.testmonkeys.koshmar.core.elements.actions.GetAttributeValueAction;
import org.testmonkeys.koshmar.core.elements.actions.GetTextAction;
import org.testmonkeys.koshmar.core.elements.actions.SendKeysAction;

/**
 * Created by cpascal on 3/29/2017.
 */
public class Input extends AbstractComponent {

    public void type(String text) {
        new SendKeysAction(this, text).execute();
    }

    public String getText(){return (new GetAttributeValueAction(this,"value").execute());}
}
