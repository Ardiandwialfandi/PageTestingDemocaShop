package com.demoqashop.teststep;

import com.demoqashop.drivers.DriverSingleton;
import com.demoqashop.pages.AddtoCartPage;
import com.demoqashop.pages.LoginDemoqaPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddtoCartTest {
    public static WebDriver driver;
    public LoginDemoqaPage pageLogin;

    public AddtoCartPage addCartPage;


    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        pageLogin = new LoginDemoqaPage();
        addCartPage = new AddtoCartPage();
        String url = "https://shop.demoqa.com/";
        driver.get(url);
        pageLogin.loginDemoc();
    }

    @AfterClass
    public void quitBrowser() {
        delay(2);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testAddtoCart(){
        addCartPage.getCartTitle();
        addCartPage.addToCart();
        Assert.assertTrue(addCartPage.getConfirmProduct().contains("BLACK STRAPPY"));
    }
    @Test (priority = 2)
    public void testClearCart(){
        delay(3);
        addCartPage.clear();
        Assert.assertTrue(addCartPage.getReturnShop().contains("Cart"));
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
