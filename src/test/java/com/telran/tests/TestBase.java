package com.telran.tests;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

   public WebDriver driver;

   Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void startTest(){
        logger.info("Start test");
    }

    @AfterMethod (enabled = false)
    public void  tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void stopTest(){
        logger.info("Stop test");
    }
}
