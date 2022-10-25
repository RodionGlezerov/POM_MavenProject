package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.ButtonsPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTests  extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectButtons();
    }


    @Test
    public void doubleClickTest(){
        new ButtonsPage(driver).doubleClick();
        Assert.assertTrue(new ButtonsPage(driver).getDoubleClickText().contains("double"));
    }

    @Test
    public void rightClickTest(){
        new ButtonsPage(driver).rightClick();
        Assert.assertTrue(new ButtonsPage(driver).getRightClickText().contains("right"));
    }
}
