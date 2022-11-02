package com.telran.pages.widgets;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends PageBase {
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipButton;

    @FindBy(css = "[aria-describedby=buttonToolTip]")
    WebElement buttonToolTip;

    @FindBy(className = "tooltip-inner")
    WebElement buttonToolTipInner;

    public ToolTipsPage hoverToolTipWithAttribute() {
        pause(500);
        click(toolTipButton);
        // String expectedToolTip = buttonToolTip.getAttribute("tooltip-inner");
        String actualToolTip = buttonToolTipInner.getText();
        //System.out.println("Retrieved tooltip as: " + expectedToolTip);
        String expectedToolTip = "You hovered over the Button";
        if (actualToolTip.equals(expectedToolTip)){
            System.out.println("PASS: Text is matching");
        }else{
            System.out.println("FAIL: Text is not matching");
        }
        return this;
    }
    @FindBy(xpath = "//a[contains(text(),'Contrary')]")
    WebElement contrary;

    public ToolTipsPage hoverToolTipContraryWithAttribute() {
        Actions actions = new Actions(driver);
        actions.moveToElement(contrary).perform();
        pause(2000);
        String actualToolTip = buttonToolTipInner.getText();
        String expectedToolTip = "You hovered over the Button";
        if (actualToolTip.equals(expectedToolTip)){
            System.out.println("PASS: Text is matching");
        }else{
            System.out.println("FAIL: Text is not matching");
        }
        return this;
    }
}
