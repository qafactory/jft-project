package com.example.tests;

import com.example.framework.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestBase {
    protected static ApplicationManager app;

    List<String> days;
    List<String> months;
    List<String> groups;

    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }

    @DataProvider
    public Iterator<Object[]> randomValidGroupsGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++){
            GroupData group = new GroupData();
            group.name = generateRandomString();
            group.header = generateRandomString();
            group.footer = generateRandomString();
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactsGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++){
            ContactData contact = new ContactData();
            contact.firstname = generateRandomString();
            contact.lastname = generateRandomString();
            contact.address = generateRandomString();
            contact.homephone = generateRandomString();
            contact.mobilephone = generateRandomString();
            contact.workphone = generateRandomString();
            contact.email1 = generateRandomString();
            contact.email2 = generateRandomString();
            contact.bday = generateRandomDaySelection();
            contact.bmonth = generateRandomMonthSelection();
            contact.byear = generateRandomString();
            contact.group = generateRandomGroupSelection();
            contact.address2 = generateRandomString();
            contact.phone2 = generateRandomString();
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactsModificationGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++){
            ContactData contact = new ContactData();
            contact.firstname = generateRandomString();
            contact.lastname = generateRandomString();
            contact.address = generateRandomString();
            contact.homephone = generateRandomString();
            contact.mobilephone = generateRandomString();
            contact.workphone = generateRandomString();
            contact.email1 = generateRandomString();
            contact.email2 = generateRandomString();
            contact.bday = generateRandomDaySelection();
            contact.bmonth = generateRandomMonthSelection();
            contact.byear = generateRandomString();
            contact.address2 = generateRandomString();
            contact.phone2 = generateRandomString();
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    public String generateRandomString(){
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0){
            return "";
        }else{
            return "contact" + rnd.nextInt();
        }
    }

    public String generateRandomDaySelection(){
        Random rnd = new Random();
        int index = rnd.nextInt(days.size());
        return days.get(index);
    }

    public String generateRandomMonthSelection(){
        Random rnd = new Random();
        int index = rnd.nextInt(months.size());
        return months.get(index);
    }

    public String generateRandomGroupSelection(){
        Random rnd = new Random();
        int index = rnd.nextInt(groups.size());
        return groups.get(index);
    }
}
