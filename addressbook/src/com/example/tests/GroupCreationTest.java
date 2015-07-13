package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class GroupCreationTest extends TestBase{

    @Test(dataProvider = "randomValidGroupsGenerator")
    public void testGroupCreationWithValidData(GroupData group) throws Exception {
        // save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

        // actions
        app.getGroupHelper().createGroup(group);

        // save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        assertThat(newList, equalTo(oldList.withAdded(group)));
    }
}
