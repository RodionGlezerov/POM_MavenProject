package com.telran.utils;

import com.telran.model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
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

    @DataProvider
    public Iterator<Object[]> newRegistrationWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/DataProviderDemoQA.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{new User().setName(split[0])
                    .setLastname(split[1]).setEmail(split[2])
                    .setPhone(split[3]).setDate(split[4])
                    .setFile(split[5]).setAddress(split[6])});
            line = reader.readLine();
        }

        return list.iterator();
    }

}
