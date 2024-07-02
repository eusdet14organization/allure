package com.eurotech.tests;

import com.eurotech.actors.LoginActor;
import com.eurotech.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorLoginTests extends TestBase{

    @Test
    public void successLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(
                new LoginActor(context)
                        .loginAsStandardUser()
                        .getFooterText()
                        .contains("Sauce Labs")
        );
    }

    @Test
    public void successLoginInternalAssertTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        new LoginActor(context)
                .loginAsStandardUser()
                .assertFooterTextContains("Sauce Labsssss");

    }
}
