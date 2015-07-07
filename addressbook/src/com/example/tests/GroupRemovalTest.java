package com.example.tests;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * Created by Emma on 6/28/2015.
 */
public class GroupRemovalTest extends TestBase{

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();

        // save old state
        List<GroupData> oldList = app.getGroupHelper().getGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);

        // actions
        app.getGroupHelper().deleteGroup(index);
        app.getGroupHelper().returnToGroupsPage();

        // save new state
        List<GroupData> newList = app.getGroupHelper().getGroups();

        // compare states
        oldList.remove(index);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
    }
}
