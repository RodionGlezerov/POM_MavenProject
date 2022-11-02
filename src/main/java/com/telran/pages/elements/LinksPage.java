package com.telran.pages.elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class LinksPage extends PageBase {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public LinksPage checkAllLinks() {
        System.out.println("Total count of links: " + links.size());
        String url = "";
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public LinksPage checkBrokenLinks() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    @FindBy(id = "linkResponse")
    WebElement linkResponse;

    @FindBy(id = "created")
    WebElement created;

    public LinksPage checkCreatedLinkTest() {
        click(created);
        return this;
    }

    @FindBy(id = "no-content")
    WebElement noContent;

    public LinksPage checkNoContentLinkTest() {
        click(noContent);
        return this;
    }



    @FindBy(id = "moved")
    WebElement moved;

    public LinksPage checkMovedLinkTest() {
        click(moved);
        return this;
    }

    public String getResponseStatusText() {
        String text = linkResponse.getText();
        System.out.println(text);
        return text;
    }


    @FindBy(id = "bad-request")
    WebElement badRequest;
    public LinksPage checkBadRequestTest() {
        click(badRequest);
        return this;
    }

    @FindBy(id = "unauthorized")
    WebElement unauthorized;

    public LinksPage checkUnauthorizedTest() {
        click(unauthorized);
        return this;
    }

    @FindBy(id = "forbidden")
    WebElement forbidden;

    public LinksPage checkForbiddenTest() {
        click(forbidden);
        return this;
    }

    @FindBy(id = "invalid-url")
    WebElement invalidUrl;

    public LinksPage checkNotFoundTest() {
        click(invalidUrl);
        return this;
    }
}
