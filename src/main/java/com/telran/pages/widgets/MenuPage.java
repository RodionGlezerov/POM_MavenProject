package com.telran.pages.widgets;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends PageBase {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subList;

    @FindBy(xpath = "//a[.='Sub Sub Item 2']")
    WebElement suSubItem2;

    public MenuPage moveToSubMenuTest() {
        Actions actions = new Actions(driver);

        pause(1000);
        //mouse hover menuOption "Main Item 2"
        actions.moveToElement(mainItem2).perform();
        System.out.println("Done Mouse Hover on" +mainItem2.getText());
        pause(1000);
        //mouse hover menuOption 'SUB SUB LIST'
        actions.moveToElement(subList).perform();
        System.out.println("Done Mouse Hover on" +subList.getText());
        pause(1000);
        //mouse hover menuOption 'Sub Sub Item 2'
        actions.moveToElement(suSubItem2).perform();
        System.out.println("Done Mouse Hover on" + suSubItem2.getText());

        return this;
    }
}
