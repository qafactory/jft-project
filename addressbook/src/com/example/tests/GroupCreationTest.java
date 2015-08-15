package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;

public class GroupCreationTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> groupsFromFile()throws IOException {
        return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
    }

    @Test(dataProvider = "groupsFromFile")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        // save old state
        SortedListOf<GroupData> oldList = app.getModel().getGroups();

        // actions
        app.getGroupHelper().createGroup(group);

        // save new state
        SortedListOf<GroupData> newList = app.getModel().getGroups();

        // compare states
        assertThat(newList, equalTo(oldList));

        // compare model to implementation
        if(wantToCheck()){
            if ("yes".equals(app.getProperty("check.db"))){
                assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
            }
            if ("yes".equals(app.getProperty("check.ui"))) {
                assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
            }
        }
    }
}
