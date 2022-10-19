package com.telran.pages.bookStore;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;


    public ProfilePage login(String uName, String pwd) {
        type(userName,uName);
        typeWithJSExecutor(password,pwd,0,100);
        click(loginButton);
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String uName, String pwd) {
        type(userName,uName);
        typeWithJSExecutor(password,pwd,0,100);
        click(loginButton);
        return this;
    }
}
