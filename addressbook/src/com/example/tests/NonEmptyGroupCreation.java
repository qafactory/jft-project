package com.example.tests;

import org.testng.annotations.Test;


public class NonEmptyGroupCreation extends TestBase{

    @Test
    public void testNonEmptyGroupCreation() throws Exception {
        openMainPage();
        gotoGroupsPage();
        initGroupCreation();
        GroupData group = new GroupData();
        group.name="home";
        group.header="header 1";
        group.footer="footer 1";
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
    }

}
