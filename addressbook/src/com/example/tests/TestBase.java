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
        for (int i = 0; i < 3; i++){
            GroupData group = new GroupData()
                    .withName(generateRandomString())
                    .withHeader(generateRandomString())
                    .withFooter(generateRandomString());
            list.add(new Object[]{group});
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> randomValidContactsGenerator(){
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < 3; i++){
            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withHomePhone(generateRandomString())
                    .withMobilePhone(generateRandomString())
                    .withWorkPhone(generateRandomString())
                    .withEmail1(generateRandomString())
                    .withEmail2(generateRandomString())
                    .withBday(generateRandomDaySelection())
                    .withBmonth(generateRandomMonthSelection())
                    .withByear(generateRandomString())
                    .withGroup(generateRandomGroupSelection())
                    .withAddress2(generateRandomString())
                    .withPhone2(generateRandomString());
            list.add(new Object[]{contact});
        }
        return list.iterator();
    }

    public String generateRandomString(){
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0){
            return "";
        }else{
            return "name" + rnd.nextInt();
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

    public void getContactFormDropdownValues() {
        app.navigateTo().mainPage();
        app.getContactHelper().initContactCreation();
        days = app.getContactHelper().getFormDaysValues();
        months = app.getContactHelper().getFormMonthsValues();
        groups = app.getContactHelper().getFormGroupsValues();
    }
}
