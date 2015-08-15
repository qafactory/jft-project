package com.example.framework;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Created by Emma on 6/27/2015.
 */
public class GroupHelper extends WebDriverHelperBase {
    
    public GroupHelper(ApplicationManager manager) {
        super(manager);
    }

    public GroupHelper createGroup(GroupData group) {
        manager.navigateTo().groupsPage();
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupsPage();
        manager.getModel().addGroup(group);
        return this;
    }

    public GroupHelper modifyGroup(int index, GroupData group) {
        initGroupModification(index);
        fillGroupForm(group);
        submitGroupModification();
        returnToGroupsPage();
        manager.getModel().removeGroup(index).addGroup(group);
        return this;
    }

    public GroupHelper deleteGroup(int index) {
        selectGroupByIndex(index);
        submitGroupDeletion();
        returnToGroupsPage();
        manager.getModel().removeGroup(index);
        return this;
    }

    //-----------------------------------------------------------------------------

    public SortedListOf<GroupData> getUiGroups(){
        SortedListOf<GroupData> groups = new SortedListOf<GroupData>();

        manager.navigateTo().groupsPage();
        List<WebElement> checkboxes =  driver.findElements(By.xpath("//input[@name='selected[]']"));
        for (WebElement checkbox: checkboxes){
            String title = checkbox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length());
            groups.add(new GroupData().withName(name));
        }
        return groups;
    }

    public GroupHelper initGroupCreation() {
        click(By.name("new"));
        return this;
    }

    public GroupHelper fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getHeader());
        type(By.name("group_footer"), group.getFooter());
        return this;
    }

    public GroupHelper submitGroupCreation() {
        click(By.name("submit"));
        return this;
    }

    public GroupHelper returnToGroupsPage() {
        click(By.linkText("group page"));
        return this;
    }

    public void selectGroupByIndex(int index){
        click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
    }

    public GroupHelper initGroupModification(int index) {
        selectGroupByIndex(index);
        click(By.xpath("//input[@name='edit']"));
        return this;
    }

    public GroupHelper submitGroupModification() {
        click(By.xpath("//input[@name='update']"));
        return this;
    }

    public void submitGroupDeletion() {
        click(By.xpath("//input[@name='delete']"));
    }
}


