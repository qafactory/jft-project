package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;
import java.util.Random;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Emma on 6/28/2015.
 */
public class GroupModificationTest extends TestBase {

    @Test (dataProvider = "randomValidGroupsGenerator")
    public void modifySomeGroup(GroupData group){
        // save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size() - 1);

        // actions

        app.getGroupHelper().modifyGroup(index,group);

        // save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();

        // compare states
        assertThat(newList, equalTo(oldList.without(index).withAdded(group)));
    }
}
