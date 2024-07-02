package com.eurotech.tests;

import com.eurotech.context.NewUserInfo;
import com.eurotech.pages.UserCreationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserCreationTest extends TestBase{

    @Test
    public void createUserAllParams() throws InterruptedException {
        context.driver.get("https://demo.wpeverest.com/user-registration/online-event-registration-form/");

        new UserCreationPage(context).createNewUser(
                "Test123",
                "User123",
                "test" + System. currentTimeMillis() + "@mail.com",
                "PA$$w0rd_absolutely_Strong",
                "48516523779",
                "Male",
                "no need",
                false,
                "Social Media",
                "no need"
        );

        assertEquals("User successfully registered.", new UserCreationPage(context).successMessage.getText());
    }

    @Test
    public void createUserObject() throws InterruptedException {
        context.driver.get("https://demo.wpeverest.com/user-registration/online-event-registration-form/");
        NewUserInfo newUserInfo = new NewUserInfo();
        newUserInfo.heardBy = "Social Media";
        new UserCreationPage(context).createNewUser(newUserInfo);

        assertEquals("User successfully registered.", new UserCreationPage(context).successMessage.getText());
    }
}
