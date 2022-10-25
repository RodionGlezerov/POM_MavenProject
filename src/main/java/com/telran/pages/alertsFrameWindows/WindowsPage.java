package com.telran.pages.alertsFrameWindows;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WindowsPage extends PageBase {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    WebElement tabButton;

    public WindowsPage clickOnNewTabButton() {
        click(tabButton);
        List<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;

    public String getTextFromNewTab() {
        return sampleHeading.getText();
    }


    @FindBy(id = "windowButton")
    WebElement windowButton;

    public WindowsPage clickInNewWindowPage() {
        click(windowButton);
        List<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(1));
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading_2;

    public String getTextFromNewWindow() {
       return sampleHeading.getText();
    }

    @FindBy(id = "messageWindowButton")
    WebElement messageWindowButton;

    public WindowsPage clickInNewWindowMessage() {
        click(messageWindowButton);
        List<String> windowMessage = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowMessage.get(1));
        return this;
    }


//    @FindBy(xpath = "//*[contains(text(),'Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.')]")
//    WebElement text;

    @FindBy(xpath = "//body")
    WebElement text;
    public String getTextFromNewWindowMessage() {

//       return text.getText();
       return  text.getText();
    }
}
