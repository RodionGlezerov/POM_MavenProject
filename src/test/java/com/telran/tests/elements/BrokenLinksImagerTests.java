package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.BrokenLinksImagesPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagerTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getElements();
        new SidePanelPage(driver).selectBrokenLinksImages();
    }

    @Test
    public void checkAllLinksTest(){
        new BrokenLinksImagesPage(driver).checkAllLinks();
    }

    @Test
    public void checkBrokenLinksTest(){
        new BrokenLinksImagesPage(driver).checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest(){
        new BrokenLinksImagesPage(driver).checkBrokenImages();
    }


}
