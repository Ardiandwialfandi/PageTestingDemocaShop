package com.demoqashop.pages;

import com.demoqashop.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDemoqaPage {
    private final WebDriver driver;

    public LoginDemoqaPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/p/a" )
    WebElement popUp;
    @FindBy(linkText = "My Account" )
    WebElement myAcc;
    @FindBy(name = "username" )
    WebElement userName;
    @FindBy(name = "password" )
    WebElement password;
    @FindBy(id = "rememberme" )
    WebElement rememberMe;
    @FindBy(name = "login" )
    WebElement login;
    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/div/p[1]/strong[1]")
    WebElement txtAccountName;

    public void getLoginTitle(){
        String title = driver.getTitle();
        System.out.println("Title : "+title);
    }
    public String getAccountName(){
        return txtAccountName.getText();
    }

    public void loginDemoc(){
        popUp.click(); System.out.println("Dismiss pop up click");
        delayDuration(1);
        myAcc.click(); System.out.println("Get to my account");
        scrollPage("0","500");
        userName.sendKeys("Ardiandwi"); System.out.println("Set Username");
        password.sendKeys("Ard14&','//"); System.out.println("Set Password");
        rememberMe.click(); System.out.println("Remember Me click");
        login.click(); System.out.println("Click Login");

    }

    public static void delayDuration(long time){
        try{
            Thread.sleep(time*1000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public void scrollPage(String atas, String bawah){
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+atas+","+bawah+")");
        System.out.println("Scroll bar");
    }


}
