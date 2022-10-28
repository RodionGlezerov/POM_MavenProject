package com.telran.tests;

import com.telran.pages.HomePage;
import com.telran.pages.PageBase;
import com.telran.pages.SidePanelPage;
import com.telran.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

   //public WebDriver driver;
   public EventFiringWebDriver driver;

   Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init(){
        driver = new EventFiringWebDriver(new ChromeDriver());
       // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //initialization of MyListener
        driver.register(new MyListener());

    }

    @AfterMethod (enabled = false)
    public void  tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test with method " + m.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: Test method " + result.getMethod().getMethodName());
            String screen = "screenshoots/screen-" + (System.currentTimeMillis()/1000%3600) + ".png";
            new PageBase(driver).takeScreenshot(screen);

        }
        logger.info("Stop test: " + result.getMethod().getMethodName());
    }
}
