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
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().editContact(index,contact);

        // save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
    }

    @Test(dataProvider = "randomValidContactsGenerator")
    public void modifySomeContact(ContactData contact) {
        // save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions
        app.getContactHelper().modifyContact(index,contact);

        // save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
    }
}
