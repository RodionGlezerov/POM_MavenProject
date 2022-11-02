package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class JSExecutor extends PageBase {

    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor enterNameAndEmailWithJSE(String name, String email) {
        if (name != null && email != null) {
            js.executeScript("document.getElementById('userName').value='" + name + "';");
            //обод text field
            js.executeScript("document.getElementById('userName').style.border='2px solid red';");

            js.executeScript("document.getElementById('userEmail').value='" + email + "';");

            WebElement userName = driver.findElement(By.id("userName"));
            System.out.println(userName.getText() + "By text");
            System.out.println(userName.getAttribute("value") + " By value");
        }
        return this;
    }

    public JSExecutor clickOnSubmitButtonWithJSE() {
        //css selector
        js.executeScript("document.querySelector('#submit').style.backgroundColor='Red';");

        js.executeScript("document.querySelector('#submit').click();");

        return this;

    }

    public JSExecutor checkBoxWithJSE() {
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false;");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");
        return this;
    }

    public JSExecutor refreshPageWithJSE() {
        //обновление страницы
        js.executeScript("history.go(0);");
        return this;
    }

    public JSExecutor getTitleWithJSE() {
        String title = js.executeScript("return document.title;").toString();
        System.out.println("-------------------------" + "\n" + title);
        return this;
    }

    public JSExecutor getURLPageWithJSE() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("----------------------" + "\n" + url);
        return this;
    }

    public JSExecutor scrollWithJSE() {
        js.executeScript("window.scrollBy(0,200);");
        return this;
    }
}
