package com.telran.pages.widgets;

import com.telran.pages.PageBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

public class SelectMenuPage extends PageBase {

    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;
    public SelectMenuPage oldStyleSelectMenu(String text) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(text);
        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("----------------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }

        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiSelectDropDown;

    @FindBy(xpath = "//html")
    WebElement space;

    public SelectMenuPage multiSelectDropDown(String text) {
        clickWithJSExecutor(multiSelectDropDown,0,300);
        WebElement element = driver.findElement(xpath(format("//div[text()='%s']", text)));
        //int - %d
        click(element);
        pause(2000);
        click(space);
        return this;
    }

    @FindBy(css = ".css-xb97g8")
    WebElement des;

    public SelectMenuPage deselect() {
        click(des);
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;
    public SelectMenuPage multiSelectDropDown1(String[] text) {
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null){
                inputSelect.sendKeys(text[i]);
                inputSelect.sendKeys(Keys.ENTER);
            }

            click(space);
        }
//        inputSelect.sendKeys(text1);
//        inputSelect.sendKeys(Keys.ENTER);
//        inputSelect.sendKeys(text2);
//        inputSelect.sendKeys(Keys.ENTER);
//        inputSelect.sendKeys(text3);
//        inputSelect.sendKeys(Keys.ENTER);
//        click(space);

        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public SelectMenuPage standartMultiSelect() {
        Select multi = new Select(cars);
        if (multi.isMultiple()){
            multi.selectByIndex(1);
            multi.selectByIndex(2);
            multi.selectByIndex(3);
        }
        List<WebElement> selectedOptions = multi.getAllSelectedOptions();
        for (WebElement element: selectedOptions) {
            System.out.println(element.getText() + "<----Multi");
        }

        return this;
    }
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement selectValue;


    public SelectMenuPage selectValue(String text) {
        click(selectValue);
        WebElement element = driver.findElement(xpath(format("//div[text()='%s']", text)));
        click(element);
        pause(2000);
        click(space);
        return this;


    }

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
    WebElement selectOne;

    public SelectMenuPage selectOne(String text) {
        click(selectOne);
        WebElement element = driver.findElement(xpath(format("//div[text()='%s']", text)));
        click(element);
        pause(2000);
        click(space);
        return this;

    }

}
