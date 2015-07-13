package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Emma on 6/20/2015.
 */
public class ContactCreationTest extends TestBase{

    @BeforeClass
    public void prerequisite(){
        getContactFormDropdownValues();
    }

    @Test(dataProvider = "randomValidContactsGenerator")
    public void testContactCreationWithValidData(ContactData contact) throws Exception{
        // save old state
        SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

        // actions
        app.getContactHelper().createContact(contact);

        // save new state
        SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

        // compare states
        assertThat(newList, equalTo(oldList.withAdded(contact)));
    }
}
