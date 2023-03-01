package com.demoqashop.teststep;

import com.demoqashop.drivers.DriverSingleton;
import com.demoqashop.pages.LoginDemoqaPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    public static WebDriver driver;
    public LoginDemoqaPage pageLogin;


    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        pageLogin = new LoginDemoqaPage();
        String url = "https://shop.demoqa.com/";
        driver.get(url);
    }

    @AfterClass
    public void quitBrowser() {
        delay(1);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidLogin(){
        delay(1);
        pageLogin.getLoginTitle();
        pageLogin.loginDemoc();
        Assert.assertEquals(pageLogin.getAccountName(),"Ardiandwi");
    }
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
