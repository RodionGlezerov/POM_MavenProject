package com.telran.pages;

import com.telran.pages.alertsFrameWindows.AlertsPage;
import com.telran.pages.bookStore.BookStorePage;
import com.telran.pages.bookStore.ProfilePage;
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
    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alerts,0,300);
        return new AlertsPage(driver);
    }
    @FindBy(xpath = "//span[.='Book Store']")
    WebElement bookStore;

    public BookStorePage selectBookStore() {
        clickWithJSExecutor(bookStore,0,500);
        return new BookStorePage(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profile;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile,0,500);
        return new ProfilePage(driver);

    }
}
