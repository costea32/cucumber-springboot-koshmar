package org.testmonkeys.starter.cucumber.springboot;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomAssert {

    private static Logger logger = LoggerFactory.getLogger(CustomAssert.class);

    public static <T> void assertThat(String reason, T actual, Matcher<? super T> matcher){
        StringDescription description = new StringDescription();
        matcher.describeTo(description);
        logger.info("Assert: "+reason+" Checking that \""+actual+"\" "+description.toString());
        Assert.assertThat(reason,actual, matcher);
    }

    public static <T> void assertThat(T actual, Matcher<? super T> matcher){
        assertThat("",actual,matcher);
    }
}
