package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Emma on 6/29/2015.
 */
public class ContactModificationTest extends TestBase {

    @Test
    public void editSomeContact() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactEditing(1);
        ContactData contact = new ContactData();
        contact.firstname = "Edited";
        contact.lastname = "Contact";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }

    @Test
    public void modifySomeContact() {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().viewContactDetails(1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData();
        contact.firstname = "Modified";
        contact.lastname = "Contact";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}
