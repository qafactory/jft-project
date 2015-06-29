package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Emma on 6/29/2015.
 */
public class ContactRemovalTest extends TestBase{

    @Test
    public void deleteSomeContactByEdit(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().initContactEditing(1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();
    }

    @Test
    public void deleteSomeContactByModify(){
        app.getNavigationHelper().openMainPage();
        app.getContactHelper().viewContactDetails(1);
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteContact();
        app.getContactHelper().returnToHomePage();
    }
}
