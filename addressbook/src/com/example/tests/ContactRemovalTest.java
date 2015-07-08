package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Emma on 6/29/2015.
 */
public class ContactRemovalTest extends TestBase{

    @Test
    public void deleteSomeContactByEdit(){
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().initContactEditing(1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(1);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test
    public void deleteSomeContactByModify(){
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().viewContactDetails(1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(1);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
