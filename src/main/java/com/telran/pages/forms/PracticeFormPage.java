package com.telran.pages.forms;

import com.telran.model.User;
import com.telran.pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Collection;

public class PracticeFormPage extends PageBase {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage hideIframes() {
        hideAd();
        // скрытие футора
        hideFooter();
        return this;
    }

    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement userNumber;


    public PracticeFormPage enterPersonalData(String fName, String lName, String email, String phNumber) {
        type(firstName, fName);
        type(lastName, lName);
        type(userEmail, email);
        type(userNumber, phNumber);
        return this;
    }

    @FindBy(css = "[for='gender-radio-1']")
    WebElement maleButton;

    @FindBy(css = "[for='gender-radio-2']")
    WebElement femaleButton;

    @FindBy(css = "[for='gender-radio-3']")
    WebElement otherButton;


    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")) {
            click(maleButton);
        } else if (gender.equals("Female")) {
            click(femaleButton);
        } else {
            click(otherButton);
        }
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage typeOfDate(String bDay) {
        clickWithJSExecutor(dateOfBirthInput, 0, 300);
        chooseOS();

        dateOfBirthInput.sendKeys(bDay);
        dateOfBirthInput.sendKeys(Keys.ENTER);
        return this;
    }

    public void chooseOS() {
        String os = System.getProperty("os.name");
        System.out.println("OS: " + os);

        if (os.startsWith("Mac")) {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            dateOfBirthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
    }


    @FindBy(css = ".react-datepicker__month-select")
    WebElement selectMonth;

    @FindBy(css = ".react-datepicker__year-select")
    WebElement selectYear;


    public PracticeFormPage chooseDate(String month, String year, String day) {
        clickWithJSExecutor(dateOfBirthInput, 0, 100);

        //HTML tag <select>
        Select select = new Select(selectMonth);
        select.selectByVisibleText(month);

        Select select1 = new Select(selectYear);
        select1.selectByVisibleText(year);

        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage addSubject(String[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] != null) {
                type(subjectsInput, subjects[i]);
                subjectsInput.sendKeys(Keys.ENTER);
            }

        }
        return this;
    }


    @FindBy(xpath = "//input[@id='hobbies-checkbox-1']/../label")
    WebElement sports;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-2']/../label")
    WebElement reading;

    @FindBy(xpath = "//input[@id='hobbies-checkbox-3']/../label")
    WebElement music;

    public PracticeFormPage chooseHobbies(String[] hobbies) {
        for (int i = 0; i < hobbies.length; i++) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadFile(String path) {
        uploadPicture.sendKeys(path);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterAddress(String address) {
        typeWithJSExecutor(currentAddress, address, 0, 200);
        return this;

    }


    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;


    public PracticeFormPage inputState(String state) {
        click(stateContainer);
        stateInput.sendKeys(state);
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage inputCity(String city) {
        click(cityContainer);
        cityInput.sendKeys(city);
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submit;

    public PracticeFormPage submit() {
        pause(1000);
        clickWithRectangle(submit, 2, 3);
        return this;
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement dialogTitle;


    public String getTitleOfDialog() {
        return dialogTitle.getText();
    }

    @FindBy(id = "closeLargeModal")
    WebElement closeButton;

    public PracticeFormPage closeSuccessDialog() {
        pause(1500);
        clickWithRectangle(closeButton, 2, 3);
        return this;
    }




    public void enterPersonalDataWithDataProvider(User user) {
       type(firstName,user.getName());
       type(lastName,user.getLastname());
       type(userEmail,user.getEmail());
       type(userNumber,user.getPhone());
    }
    public void setDateDataProvider(String date) {

    }



}


