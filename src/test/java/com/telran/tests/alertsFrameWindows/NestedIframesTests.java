package com.telran.tests.alertsFrameWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.alertsFrameWindows.NestedFramesPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedIframesTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanelPage(driver).selectNestedFrames();
    }

    @Test
    public void handleNestedIframestest(){
        new NestedFramesPage(driver).handleNestedIframes();

    }


    @Test
    public void switchToParentFrameTest(){
        new NestedFramesPage(driver).switchToParentFrame();
    }
}
