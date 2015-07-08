package com.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Emma on 6/20/2015.
 */
public class ContactCreationTest extends TestBase{

    @BeforeClass
    public void getFormValues(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        days = app.getContactHelper().getFormDaysValues();
        months = app.getContactHelper().getFormMonthsValues();
        groups = app.getContactHelper().getFormGroupsValues();
    }

    @Test(dataProvider = "randomValidContactsGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception{
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
