package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.TextBoxPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectTextBox();
    }

    @Test
    public void keyBoardEventTest(){
        new TextBoxPage(driver).keyBoardEvent();
        Assert.assertEquals(new TextBoxPage(driver).getAttribute(),"Berlin");

    }
}
