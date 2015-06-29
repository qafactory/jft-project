package com.example.tests;

import org.testng.annotations.Test;

/**
 * Created by Emma on 6/28/2015.
 */
public class GroupModificationTest extends TestBase {

    @Test
    public void modifySomeGroup(){
        app.getNavigationHelper().openMainPage();
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupHelper().initGroupModification(1);
        GroupData group = new GroupData();
        group.name = "new name";
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
    }
}
