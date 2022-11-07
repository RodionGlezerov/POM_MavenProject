package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.UploadAndDownloadPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectUploadAndDownLoad();
    }

    @Test
    public void robotKeyEventTestForWindows(){
        new UploadAndDownloadPage(driver).performKeyEventUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(driver).getPath().contains(".txt"));
    }

    @Test
    public void robotMouseEvenTest(){
        new UploadAndDownloadPage(driver).performMouseEventUsingRobot();
    }

}
