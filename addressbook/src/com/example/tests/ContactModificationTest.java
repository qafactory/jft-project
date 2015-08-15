package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import java.util.Random;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Emma on 6/29/2015.
 */
public class ContactModificationTest extends TestBase {

    @Test(dataProvider = "randomValidContactsGenerator")
    public void editSomeContact(ContactData contact){
        // save old state
        SortedListOf<ContactData> oldList = app.getModel().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().editContact(index,contact);

        // save new state
        SortedListOf<ContactData> newList = app.getModel().getContacts();

        // compare states
        assertThat(newList, equalTo(oldList));
    }

    @Test(dataProvider = "randomValidContactsGenerator")
    public void modifySomeContact(ContactData contact) {
        // save old state
        SortedListOf<ContactData> oldList = app.getModel().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().modifyContact(index,contact);

        // save new state
        SortedListOf<ContactData> newList = app.getModel().getContacts();

        // compare states
        assertThat(newList, equalTo(oldList));
    }
}
