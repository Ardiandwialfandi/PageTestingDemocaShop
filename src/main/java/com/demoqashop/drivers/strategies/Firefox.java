package com.demoqashop.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy{
    @Override
    public WebDriver setStrategy() {
        String locDriver = "C:\\juaracoding\\geckodriver.exe";
        System.setProperty("webdriver.chrome.driver",locDriver);
        return new FirefoxDriver();
    }
}
