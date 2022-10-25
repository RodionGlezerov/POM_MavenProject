package com.telran.pages;

import com.telran.pages.alertsFrameWindows.AlertsPage;
import com.telran.pages.alertsFrameWindows.FramesPage;
import com.telran.pages.alertsFrameWindows.NestedFramesPage;
import com.telran.pages.alertsFrameWindows.WindowsPage;
import com.telran.pages.bookStore.BookStorePage;
import com.telran.pages.bookStore.ProfilePage;
import com.telran.pages.elements.ButtonsPage;
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
    @FindBy(css = ".show #item-0")
    WebElement windows;

    public WindowsPage selectWindows() {
        clickWithJSExecutor(windows,0,200);
        return new WindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramesPage selectFrames() {
        clickWithJSExecutor(frames,0,200);
        return new FramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;

    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames,0,300);
        return  new NestedFramesPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons,0,500);
        return new ButtonsPage(driver);
    }
}
