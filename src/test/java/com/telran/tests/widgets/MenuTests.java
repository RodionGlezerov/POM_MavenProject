package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.MenuPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.logging.Handler;

public class MenuTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getWidgets();
        new SidePanelPage(driver).getMenu();
    }

    @Test
    public void moveToSubMenuTest(){
        new MenuPage(driver).moveToSubMenuTest();
    }


}
