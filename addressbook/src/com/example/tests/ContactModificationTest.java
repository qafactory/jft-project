package com.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by Emma on 6/29/2015.
 */
public class ContactModificationTest extends TestBase {

    @BeforeClass
    public void getFormValues(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        days = app.getContactHelper().getFormDaysValues();
        months = app.getContactHelper().getFormMonthsValues();
        groups = app.getContactHelper().getFormGroupsValues();
    }

    @Test(dataProvider = "randomValidContactsModificationGenerator")
    public void editSomeContact(ContactData contact){
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().initContactEditing(index);
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(index);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test(dataProvider = "randomValidContactsModificationGenerator")
    public void modifySomeContact(ContactData contact) {
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().viewContactDetails(index);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(index);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
