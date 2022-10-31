package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.SelectMenuPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        new HomePage(driver).getWidgets();
        new SidePanelPage(driver).getSelectManu();
    }

    @Test
    public void oldStyleSelectManuTests(){
        new SelectMenuPage(driver).oldStyleSelectMenu("Black");
    }

    @Test
    public void multiSelectDropDownTest(){
        new SelectMenuPage(driver).multiSelectDropDown("Red").deselect().multiSelectDropDown1(new String[]{"Red", "Blue", "Green"});
    }

    @Test
    public void standartMultiSelectTest(){
        new SelectMenuPage(driver).standartMultiSelect();
    }

    @Test
    public void selectValue(){
        new SelectMenuPage(driver).selectValue("Group 2, option 1");
        // пытался сделать через int %d - не получалось найти элемент
    }

    @Test
    public void selectOne(){
        new SelectMenuPage(driver).selectOne("Other");

    }

    @Test
    public void selectOne_1(){
        new SelectMenuPage(driver).selectOne_1(3);
    }




}
