package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.AuthProvider;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName-value")
    WebElement user;

    @FindBy(id = "submit")
    WebElement logoutButton;


    public ProfilePage verifyUserName(String uName) {
        if (user.getText().equalsIgnoreCase(uName)){
            System.out.println("Correct user name is " + user.getText());
        } else {
            System.out.println("Incorrect user name is " + user.getText());
        }
        return this;
    }

    public LoginPage logout(){
        click(logoutButton);
        return  new LoginPage(driver);
    }
}
