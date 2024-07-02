package com.eurotech.tests;

import com.eurotech.pages.LoginPage;
import com.eurotech.utils.ConfigurationReader;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends TestBase {

    @Test
    @DisplayName("Тест на успешную авторизацию пользователя")
    @Description("Описание теста")
    @Severity(CRITICAL)
    @Owner("Андрей Бровко")
    @Link(name = "Website", url = "https://www.saucedemo.com/")
    @Issue("JIRA-123")
    @TmsLink("TMS-456")
    @Epic("Авторизация")
    @Feature("Вход в систему")
    @Story("Успешный вход в систему")
    public void successLoginTest() {
        Allure.label("parentSuite","Smoke Suite");
        Allure.suite("Smoke");
        context.driver.get(ConfigurationReader.get("base_url"));
        assertTrue(new LoginPage(context)
                .loginAsStandardUser()
                .getFooterText()
                .contains("Sauce Labs"));
    }

    @Test
    public void emptyTest() {
        Allure.suite("Manual");
        Allure.step("Шаг 1 через метод step");
        Allure.step("Шаг 2 через метод step");
        Allure.step("Шаг 3 через метод step");
        Allure.step("Шаг 4 через метод step");
    }

    @Epic("Авторизация")
    @Feature("Вход в систему")
    @Story("Ошибка при входе в систему")
    @Test
    public void emptyLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));

        assertEquals("Epic sadface: Username is required",
                new LoginPage(context).incorrectLoginAs("",""));
    }

    @Test
    public void blockedUserLoginTest() {
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(
                "Epic sadface: Sorry, this user has been locked out.",
                new LoginPage(context).incorrectLoginAs("locked_out_user","secret_sauce")
        );
    }
}
