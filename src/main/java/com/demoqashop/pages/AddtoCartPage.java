package com.demoqashop.pages;

import com.demoqashop.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class AddtoCartPage {
    private final WebDriver driver;

    private JavascriptExecutor js;

    public AddtoCartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "Checkout")
    WebElement ceckout;
    @FindBy(xpath = "(//a[normalize-space()='Return to shop'])[1]")
    WebElement returnShop;
    @FindBy(xpath = "(//span)[28]")
    WebElement productOne;
    @FindBy(xpath = "(//button[@title='Close (Esc)'])[1]")
    WebElement otherProd;
    @FindBy(xpath= "(//span[contains(@class,'noo-quick-view icon_zoom-in_alt')])[6]")
    WebElement productTwo;
    @FindBy(xpath = "(//a[contains(@class,'noo-quick-link')])[1]")
    WebElement selectProduct;
    @FindBy(id = "pa_color")
    WebElement color;
    @FindBy(id = "pa_size")
    WebElement size;
    @FindBy(className = "qty-increase")
    WebElement increament;
    @FindBy(className = "qty-decrease")
    WebElement decreament;
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addCart;
    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a")
    WebElement viewCartBtn;
    @FindBy(xpath = "//a[normalize-space()='black strappy polka dot ruched midi dress - Black']")
    WebElement textConfirmAdd;

    @FindBy(xpath = "//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[2]/td/a[1]")
    WebElement clearCart;

    public void getCartTitle(){
        String title = driver.getTitle();
        System.out.println("Title : "+title);
    }
    public String getConfirmProduct(){
        return textConfirmAdd.getText();
    }

    public void addToCart(){
        delayDuration(1);
        ceckout.click(); System.out.println("Get to checkout");
        scrollPage("0","300");
        delayDuration(1);
        returnShop.click(); System.out.println("Return to shop");
        scrollPage("0","600");
        productOne.click(); System.out.println("click product 1");
        delayDuration(2);
        otherProd.click(); System.out.println("option other product");
        delayDuration(1);
        scrollPage("0","500");
        productTwo.click(); System.out.println("click product 2");
        delayDuration(2);
        selectProduct.click(); System.out.println("Select product two");
        scrollPage("0","620");
        delayDuration(2);
        Select selectColor= new Select(color);
        selectColor.selectByVisibleText("Black"); System.out.println("Select color success");
        delayDuration(1);
        Select selectSize= new Select(size);
        int selectedSize = driver.findElements(By.tagName("select")).size();
        Random randomSelect = new Random();
        int selectedRandom = randomSelect.nextInt(selectedSize);
        selectSize.selectByIndex(Math.max(selectedRandom, 1)); System.out.println("Select size success");
        delayDuration(2);
        increament.click(); System.out.println("Quantity Increament");
        decreament.click(); System.out.println("Quantity Deccreament");
        addCart.click(); System.out.println("Click Add to cart");
        delayDuration(1);
        viewCartBtn.click(); System.out.println("View cart");
        scrollPage("0","600");
    }

    public void clear(){
        clearCart.click(); System.out.println("clear cart");
    }
    public String getReturnShop(){
        String titleShop = driver.getTitle();
        System.out.println("Title : "+titleShop);
        return titleShop;
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
