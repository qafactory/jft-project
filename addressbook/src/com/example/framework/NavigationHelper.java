package com.example.framework;

import org.openqa.selenium.By;

/**
 * Created by Emma on 6/27/2015.
 */
public class NavigationHelper extends HelperBase{

    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public  void openMainPage() {
        driver.get(manager.baseUrl + "/addressbookv4.1.4/");
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }
}
