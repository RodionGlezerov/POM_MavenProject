package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Book Store Application')]")
    WebElement bookStoreApp;


    public void clickStore(){
        pause(2000);
        clickWithJSExecutor(bookStoreApp,149,662);
        pause(2000);
        new HomePage(driver);
    }

}
