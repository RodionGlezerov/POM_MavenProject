package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Book Store Application')]")
    WebElement bookStoreApp;


    public void clickStore(){
        pause(2000);
        clickWithJSExecutor(bookStoreApp,149,662);
        pause(2000);
        new HomePage(driver);
    }
    @FindBy(xpath = "//div[.='Alerts, Frame & Windows']")
    WebElement alertsFrameWindows;

    public SidePanelPage getAlertsFrameWindows() {
        clickWithJSExecutor(alertsFrameWindows,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//div[.='Elements']")
    WebElement elements;

    public SidePanelPage getElements() {
        clickWithJSExecutor(elements,0,300);
        return new SidePanelPage(driver);
    }
    @FindBy(xpath = "//div[.='Widgets']")
    WebElement widgets;

    public SidePanelPage getWidgets() {
        clickWithJSExecutor(widgets,0,300);
        return new SidePanelPage(driver);
    }

    @FindBy(xpath = "//div[.='Interactions']")
    WebElement interactions;
    public SidePanelPage getIneractions() {
        clickWithJSExecutor(interactions,0,300);
        return new SidePanelPage(driver);
    }
}
