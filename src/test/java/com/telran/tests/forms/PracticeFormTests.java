package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.model.User;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).getForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void fillStudentRegistrationFormTest() {
        new PracticeFormPage(driver).hideIframes().enterPersonalData(StudentData.FIRST_NAME,
                        StudentData.LAST_NAME, StudentData.EMAIL, StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
                .typeOfDate(StudentData.DATE)
                .chooseDate("May", "2022", "24")
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .submit();

        Assert.assertTrue(new PracticeFormPage(driver).getTitleOfDialog().contains("Thanks for"));
    }


    @AfterMethod(enabled = true)
    public void closeDialog() {
        new PracticeFormPage(driver).closeSuccessDialog();
    }



    @Test (dataProvider = "newRegistration",dataProviderClass = DataProviders.class)
    public void fillStudentRegistrationFormTestWithDataProvider(String name,String lName,String email, String phone,String date,String path,String address) {
        new PracticeFormPage(driver).hideIframes().enterPersonalDataWithDataProvider(new User()
                        .setName(name)
                        .setLastname(lName)
                        .setEmail(email)
                        .setPhone(phone));
        new PracticeFormPage(driver).typeOfDate(date);
        new PracticeFormPage(driver)
                .selectGender(StudentData.GENDER)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES);
        new PracticeFormPage(driver)
                .uploadFile(path)
                .enterAddress(address);
        new PracticeFormPage(driver)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .submit();
        Assert.assertTrue(new PracticeFormPage(driver).getTitleOfDialog().contains("Thanks for"));
    }

@Test(dataProvider = "newRegistrationWithCSV",dataProviderClass = DataProviders.class)
    public void fillStudentRegistrationFormTestWithDataProviderWithCSV(User user) {
        new PracticeFormPage(driver).hideIframes().enterPersonalDataWithDataProviderWithCSV(user);
        new PracticeFormPage(driver)
                .selectGender(StudentData.GENDER)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobbies(StudentData.HOBBIES);
        new PracticeFormPage(driver)
                .inputState(StudentData.STATE)
                .inputCity(StudentData.CITY)
                .submit();
        Assert.assertTrue(new PracticeFormPage(driver).getTitleOfDialog().contains("Thanks for"));
    }



}
