package com.telran.pages.interactions;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends PageBase {
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "draggable")
    WebElement dragME;

    @FindBy(id = "droppable")
    WebElement droppHere;

    public DragAndDropPage actionDragMe() {
        Actions actions = new Actions(driver);
        pause(2000);
        actions.dragAndDrop(dragME, droppHere).perform();
        String textTo = droppHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Sources dropped to target as expected");
        } else {
            System.out.println("FAIL");
        }
        return this;
    }

    public DragAndDropPage dragAndDropBy() {
        Actions actions = new Actions(driver);

        int xOffSet = dragME.getLocation().getX();
        int yOffSet = dragME.getLocation().getY();
        System.out.println("xOffSet-->" + xOffSet + "yOffSet-->" + yOffSet);

        int xOffSet1 = droppHere.getLocation().getX();
        int yOffSet1 = droppHere.getLocation().getY();

        xOffSet1 = (xOffSet1 - xOffSet) + 50;
        yOffSet1 = (yOffSet1 - yOffSet) + 100;

        pause(2000);

        actions.dragAndDropBy(dragME,xOffSet1,yOffSet1).perform();

        String textTo = droppHere.getText();
        if (textTo.equals("Dropped!")) {
            System.out.println("PASS: Sources dropped to target as expected");
        } else {
            System.out.println("FAIL");
        }
        return this;

    }

    public DragAndDropPage dragAndDropByIndex(int x, int y ) {
        Actions actions = new Actions(driver);
        pause(1000);
        actions.dragAndDropBy(dragME,x,y).perform();
        return this;
    }
}
