package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Emma on 6/29/2015.
 */
public class ContactModificationTest extends TestBase {

    @Test
    public void editSomeContact() {
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().initContactEditing(1);
        ContactData contact = new ContactData();
        contact.firstname = "Edited";
        contact.lastname = "Contact";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(1);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }

    @Test
    public void modifySomeContact() {
        app.getNavigationHelper().openMainPage();

        // save old state
        List<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().viewContactDetails(1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData();
        contact.firstname = "Modified";
        contact.lastname = "Contact";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();

        // save new state
        List<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        oldList.remove(1);
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
