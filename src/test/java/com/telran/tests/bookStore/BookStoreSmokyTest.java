package com.telran.tests.bookStore;

import com.telran.data.BookData;
import com.telran.data.UserData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.bookStore.BookStorePage;
import com.telran.pages.bookStore.LoginPage;
import com.telran.pages.bookStore.ProfilePage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreSmokyTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).clickStore();
        new SidePanelPage(driver).loginButtonSidePanel();
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD).pause(2000);
    }

    @Test
    public void addBookToCollectionTest(){
        new SidePanelPage(driver).selectBookStore();
        new BookStorePage(driver).searchBook(BookData.BOOK_NAME).clickOnFirstBook()
                .addToYourCollection();
        new SidePanelPage(driver).selectProfile();
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains("Git"));
    }

    @AfterMethod
    public void deleteBook(){
        new ProfilePage(driver).deleteBook();
    }
}
