package com.telran.tests.bookStore;

import com.telran.data.BookData;
import com.telran.pages.bookStore.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTests  extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).clickStore();
    }

    @Test
    public void searchBookPositiveTest(){
        new BookStorePage(driver).searchBook(BookData.BOOK_NAME);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_NAME));
    }

    @Test
    public void searchBookNegativeTest(){
        new BookStorePage(driver).searchBook("  ");
        Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));
    }

}
