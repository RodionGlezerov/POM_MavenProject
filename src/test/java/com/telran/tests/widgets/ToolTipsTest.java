package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.ToolTipsPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.logging.Handler;

public class ToolTipsTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getWidgets();
        new SidePanelPage(driver).selectToolTips();
    }

    @Test
    public void hoverTooTipWithAttribute(){
        new ToolTipsPage(driver).hoverTooTipWithAttribute();
    }
}
