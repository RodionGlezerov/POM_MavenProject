package com.telran.pages.bookStore;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(id = "delete-record-undefined")
    List<WebElement> bookList;

    @FindBy(id = "closeSmallModal-ok")
    WebElement okButton;

    public ProfilePage deleteBook() {
        pause(2000);
        bookList.get(0).click();
        pause(2000);
        click(okButton);
        pause(2000);
        driver.switchTo().alert().accept();
        return this;
    }
}
