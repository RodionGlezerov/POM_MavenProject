package com.telran.utils;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> newRegistration() {

        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Max","Hartfil","max@gmail.com","1234567321","09 March 1955","/Users/rodionglezerov/Desktop/7_ptm_252965.pdf","Haifa"});
        return list.iterator();
    }

}
