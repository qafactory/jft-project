package com.example.framework;

import com.example.tests.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase{
    
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.firstname);
        type(By.name("lastname"), contactData.lastname);
        type(By.name("address"), contactData.address);
        type(By.name("home"), contactData.homephone);
        type(By.name("mobile"), contactData.mobilephone);
        type(By.name("work"), contactData.workphone);
        type(By.name("email"), contactData.email1);
        type(By.name("email2"), contactData.email2);
        selectByText(By.name("bday"), contactData.bday);
        selectByText(By.name("bmonth"), contactData.bmonth);
        type(By.name("byear"), contactData.byear);
        selectByText(By.name("new_group"), contactData.group);
        type(By.name("address2"), contactData.address2);
        type(By.name("phone2"), contactData.phone2);
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void initContactEditing(int index){
        click(By.xpath("(//img[@title='Edit'])[" + index + "]"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void viewContactDetails(int index) {
        click(By.xpath("(//img[@title='Details'])[" + index + "]"));
    }


    public void initContactModification() {
        click(By.xpath("//input[@name='modifiy']"));
    }
}
