package com.telran.pages.elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.security.Key;

public class TextBoxPage extends PageBase {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage keyBoardEvent() {
        Actions actions = new Actions(driver);
        type(userName,"Tom");
        type(userEmail,"Tom@gmail.com");
        typeWithJSExecutor(currentAddress,"Berlin",0,100);
        //select
        actions.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
        //copy
        actions.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
        //press TAV to switch focus tj the permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past the address in the permanent address
        actions.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();

//        String cAddress = currentAddress.getAttribute("value");
//        System.out.println("Value if attribute: " + cAddress);
//
//        String pAddress = permanentAddress.getAttribute("value");
//        System.out.println("Value if attribute: " + pAddress);
//
//        Assert.assertEquals(cAddress,pAddress);
        return this;
    }

    public String getAttribute() {

        return currentAddress.getAttribute("value");
    }
}
