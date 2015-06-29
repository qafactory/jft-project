package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Emma on 6/20/2015.
 */
public class ContactCreationTest extends TestBase{

    @Test
    public void testNonEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData();
        contact.firstname = "First";
        contact.lastname = "Last";
        contact.address = "New York";
        contact.homephone = "2555555";
        contact.mobilephone = "789352524354";
        contact.workphone = "2559045";
        contact.email1 = "bobtal@yahoo.com";
        contact.email2 = "bobtal@gmail.com";
        contact.bday = "26";
        contact.bmonth = "March";
        contact.byear = "1970";
        contact.group = "work";
        contact.address2 = "Chicago";
        contact.phone2 = "20349809";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }

    @Test
    public void testEmptyContactCreation() throws Exception {
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactCreation();
        ContactData contact = new ContactData();
        contact.firstname = "";
        contact.lastname = "";
        contact.address = "";
        contact.homephone = "";
        contact.mobilephone = "";
        contact.workphone = "";
        contact.email1 = "";
        contact.email2 = "";
        contact.bday = "-";
        contact.bmonth = "-";
        contact.byear = "";
        contact.group = "[none]";
        contact.address2 = "";
        contact.phone2 = "";
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}
