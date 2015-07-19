package com.example.tests;

import com.example.framework.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.util.*;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        String configFile = System.getProperty("configFile", "chrome.properties");
        Properties properties = new Properties();
        properties.load(new FileReader((new File(configFile))));
        app = new ApplicationManager(properties);
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupsGenerator(){
        return wrapGroupsForDataProvider(generateRandomGroups(3)).iterator();
    }

    public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group : groups){
            list.add(new Object[]{group});
        }
        return list;
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactsGenerator() {
        return wrapContactsForDataProvider(generateRandomContacts(3)).iterator();
    }

    public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (ContactData contact : contacts){
            list.add(new Object[]{contact});
        }
        return list;
    }
}
