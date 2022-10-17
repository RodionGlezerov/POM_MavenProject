package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase{

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Login')]")
    WebElement loginSidePanel;

    public SidePanelPage loginButtonSidePanel(){
        pause(2000);
        clickWithJSExecutor(loginSidePanel,0,500);
        return this;
    }
}
