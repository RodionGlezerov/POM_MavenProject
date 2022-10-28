package com.telran.tests.interactions;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.interactions.DragAndDropPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getIneractions();
        new SidePanelPage(driver).selectDroppable();
    }

    @Test
    public void droppableTest(){
        new DragAndDropPage(driver).actionDragMe();
    }

    @Test
    public void dragAndDropByTest(){
        new DragAndDropPage(driver).dragAndDropBy();
    }

    @Test
    public void dragAndDropByIndexTest(){
        new DragAndDropPage(driver).dragAndDropByIndex(250,50);
    }
}
