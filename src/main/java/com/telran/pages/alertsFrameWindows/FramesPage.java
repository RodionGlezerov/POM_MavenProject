package com.telran.pages.alertsFrameWindows;

import com.telran.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

public class FramesPage extends PageBase {
    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    public FramesPage returnListOfIframes() {
        pause(2000);
        //By finding all the web elements using frame tag
        System.out.println("Number of frames on the page are " + iframes.size());

        //By executing JS
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Total number of iframes are " + numberOfIframes);
        return this;
    }

    public FramesPage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return  this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramesPage switchToIframeById() {
        driver.switchTo().frame(frame1);
//      driver.switchTo().defaultContent();
        return this;
    }


    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public String getTextFromIframe() {
        return sampleHeading.getText();
    }
}
