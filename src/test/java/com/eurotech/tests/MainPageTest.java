package com.eurotech.tests;

import com.eurotech.context.TestContext;
import com.eurotech.pages.BasePage;
import com.eurotech.pages.LoginPage;
import com.eurotech.utils.ConfigurationReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest extends TestBase {

    @Test
    public void testAddItemsToCart(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals("6",new LoginPage(context)
                .loginAsStandardUser()
                .clickAllAddToCartButtons()
                .shoppingCartLink.getText());
    }

    @Test
    public void testAddItemsToCartNumber(){
        context.driver.get(ConfigurationReader.get("base_url"));
        assertEquals(6,new LoginPage(context)
                .loginAsStandardUser()
                .clickAllAddToCartButtons()
                .getShoppingCartItemsAmount());
    }

}
