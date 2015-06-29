package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Emma on 6/28/2015.
 */
public class GroupRemovalTest extends TestBase{

    @Test
    public void deleteSomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().deleteGroup(1);
        app.getGroupHelper().returnToGroupsPage();
    }
}
