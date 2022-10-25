package com.telran.tests.alertsFrameWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.alertsFrameWindows.FramesPage;
import com.telran.pages.alertsFrameWindows.WindowsPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframesTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).getAlertsFrameWindows();
        new SidePanelPage(driver).selectFrames();
    }

    @Test
    public void returnListOfIframesTest(){
        new FramesPage(driver).returnListOfIframes();
    }

    @Test
    public void switchToIframeByIndexTest(){
        new FramesPage(driver).switchToIframeByIndex(1);
        Assert.assertTrue(new FramesPage(driver).getTextFromIframe().contains("sample page"));
    }

    @Test
    public void switchToIframeByIdTest(){
        new FramesPage(driver).switchToIframeById();
        Assert.assertTrue(new FramesPage(driver).getTextFromIframe().contains("This"));
        driver.switchTo().defaultContent();
    }


}
