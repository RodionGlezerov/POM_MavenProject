package com.telran.pages.elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Collection;

public class UploadAndDownloadPage extends PageBase {
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public UploadAndDownloadPage performKeyEventUsingRobot() {
        clickWithRectangle(uploadFile, 12, 2);
        // create object Robot class
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //Code to enter D1.txt
        //1. Press Shift key
        robot.keyPress(KeyEvent.VK_SHIFT);
        //2. To type D(upper case)
        robot.keyPress(KeyEvent.VK_D);
        //3. To release Shift key to release upper case effect
        robot.keyRelease(KeyEvent.VK_SHIFT);
        //4. To type 1.txt
        robot.keyPress(KeyEvent.VK_1);
        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_T);
        //5. To press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }


    public String getPath() {
        return uploadedFilePath.getText();
    }


    public UploadAndDownloadPage performMouseEventUsingRobot() {
        pause(500);
        clickWithRectangle(uploadFile, 12, 2);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
        //1. Find x and y
        Dimension i = driver.manage().window().getSize();
        System.out.println("Dimension x and y : " + i.getWidth() + " x " + i.getHeight());
        //2. To get the high and width of the screen
        int x = i.getWidth() / 4 + 1000;
        int y = i.getHeight() / 10 + 700;
        //3. To move the mouse on the x,y coordinates
        robot.mouseMove(x,y);
        pause(1000);
        //4. To click left mouse button
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //5. To release left mouse button
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        pause(1000);
        //6. To close popup
        robot.keyPress(KeyEvent.VK_ENTER);
        return this;
    }
}
