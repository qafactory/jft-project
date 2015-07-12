package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by Emma on 6/29/2015.
 */
public class ContactRemovalTest extends TestBase{

    @Test
    public void deleteSomeContactByEdit(){
        app.navigateTo().mainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);

        // actions
        app.getContactHelper().initContactEditing(index);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test
    public void deleteSomeContactByModify(){
        app.navigateTo().mainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);

        // actions
        app.getContactHelper().viewContactDetails(index);
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
