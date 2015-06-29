package com.example.framework;

import com.example.tests.GroupData;
import org.openqa.selenium.By;

/**
 * Created by Emma on 6/27/2015.
 */
public class GroupHelper extends HelperBase{
    
    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public void returnToGroupsPage() {
        click(By.linkText("group page"));
    }

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.name);
        type(By.name("group_header"), group.header);
        type(By.name("group_footer"), group.footer);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }


    public void deleteGroup(int index) {
        selectGroupByIndex(index);
        click(By.xpath("//input[@name='delete']"));
    }

    public void selectGroupByIndex(int index){
        click(By.xpath("//input[@name='selected[]'][" + index + "]"));
    }

    public void initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.xpath("//input[@name='edit']"));
    }

    public void submitGroupModification() {
        click(By.xpath("//input[@name='update']"));
    }
}
