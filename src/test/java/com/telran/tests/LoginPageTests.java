package com.telran.tests;

import com.telran.pages.HomePage;
import com.telran.pages.LoginPage;
import com.telran.pages.ProfilePage;
import com.telran.pages.SidePanelPage;
import org.testng.annotations.Test;

public class LoginPageTests extends  TestBase{

    @Test
    public void loginPositiveTest(){
        new HomePage(driver).clickStore();
        new SidePanelPage(driver).loginButtonSidePanel();
        new LoginPage(driver).login("Tom","!Tom1234");
        new ProfilePage(driver).verifyUserName("Tom").logout();
    }

}
