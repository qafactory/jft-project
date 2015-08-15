package com.example.tests;

import com.example.utils.SortedListOf;
import org.testng.annotations.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;


/**
 * Created by Emma on 6/28/2015.
 */
public class GroupRemovalTest extends TestBase{

    @Test
    public void deleteSomeGroup(){
        // save old state
        SortedListOf<GroupData> oldList = app.getGroupHelper().getUiGroups();

        Random rnd = new Random();
        int index = rnd.nextInt(oldList.size()-1);

        // actions
        app.getGroupHelper().deleteGroup(index);

        // save new state
        SortedListOf<GroupData> newList = app.getGroupHelper().getUiGroups();

        // compare states
        assertThat(newList, equalTo(oldList.without(index)));

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
