package com.telran.pages.alertsFrameWindows;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NestedFramesPage extends PageBase {
    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframe;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;



    public NestedFramesPage handleNestedIframes() {
        hideAd();
        System.out.println("Number of Iframes on this page is: "+ iframe.size());
       // switch to parent frame and print text
        driver.switchTo().frame(frame1);
        pause(2000);
        System.out.println("Frame1 is " + body.getText());
        //number of iframe on a Frame1
        System.out.println("Number of Iframes inside the parent frame: " + iframe.size());
        //switch to the child frame  an printer text
        driver.switchTo().frame(0);
        pause(2000);
        System.out.println("Frame2 is " + body.getText());
        System.out.println("Number of Iframe inside the Frame2: " + iframe.size());
        return this;
    }

    public NestedFramesPage switchToParentFrame() {
        driver.switchTo().frame(frame1);
        System.out.println("Frame1 is " + body.getText());
        driver.switchTo().frame(0);
        System.out.println("Frame2 is " + body.getText());
        driver.switchTo().parentFrame();
        System.out.println("Frame2 is " + body.getText());
        return this;
    }
}
