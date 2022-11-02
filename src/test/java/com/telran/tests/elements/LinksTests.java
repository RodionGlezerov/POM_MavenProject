package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.LinksPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectLinks();
    }

    @Test
    public void checkAllLinksTest() {
        new LinksPage(driver).checkAllLinks();
    }

    @Test
    public void checkBrokenLinksTest() {
        new LinksPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkCreatedLinkTest() {
        new LinksPage(driver).checkCreatedLinkTest();
        Assert.assertTrue(new LinksPage(driver).getResponseStatusText().contains("201"));
    }

    @Test
    public void checkNoContentLinkTest(){
        new LinksPage(driver).checkNoContentLinkTest();
        Assert.assertTrue(new LinksPage(driver).getResponseStatusText().contains("204"));
    }
    @Test
    public void checkMovedLinkTest(){
        new LinksPage(driver). checkMovedLinkTest();
        Assert.assertTrue(new LinksPage(driver).getResponseStatusText().contains("301"));
    }

    @Test
    public void checkBadRequestTest(){
        new LinksPage(driver).checkBadRequestTest();
        Assert.assertTrue(new LinksPage(driver).getResponseStatusText().contains("400"));
    }

    @Test
    public void checkUnauthorizedTest(){
        new LinksPage(driver).checkUnauthorizedTest();
        Assert.assertTrue(new LinksPage(driver).getResponseStatusText().contains("401"));
    }

    @Test
    public void checkForbiddenTest(){
        new LinksPage(driver).checkForbiddenTest();
        Assert.assertTrue(new LinksPage(driver).getResponseStatusText().contains("403"));
    }

    @Test
    public void checkNotFoundTest(){
        new LinksPage(driver).checkNotFoundTest();
        Assert.assertTrue(new LinksPage(driver).getResponseStatusText().contains("404"));
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
