package com.example.framework;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
        click(By.xpath("(//img[@title='Edit'])[" + (index+1) + "]"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void viewContactDetails(int index) {
        click(By.xpath("(//img[@title='Details'])[" + (index + 1) + "]"));
    }


    public void initContactModification() {
        click(By.xpath("//input[@name='modifiy']"));
    }

    public List<ContactData> getContacts() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> entries =  driver.findElements(By.xpath("//tbody/tr[@name='entry']/td[2]"));
        for (WebElement entry: entries){
            ContactData contact = new ContactData();
            String name = entry.getText();
            contact.lastname = name;
            contacts.add(contact);
        }
        return contacts;
    }

    public List<String> getFormDaysValues(){
        List<String> days = new ArrayList<String>();
        List<WebElement> values = driver.findElements(By.xpath("//select[@name='bday']/option"));
        for (int i = 0; i < values.size(); i++) {
            String text = values.get(i).getText();
            days.add(text);
        }
        return days;
    }

    public List<String> getFormMonthsValues(){
        List<String> months = new ArrayList<String>();
        List<WebElement> values = driver.findElements(By.xpath("//select[@name='bmonth']/option"));
        for(int i = 0; i< values.size(); i++){
            String text = values.get(i).getText();
            months.add(text);
        }
        return months;
    }

    public List<String> getFormGroupsValues(){
        List<String> groups = new ArrayList<String>();
        List<WebElement> values = driver.findElements(By.xpath("//select[@name='new_group']/option"));
        for(int i = 0; i< values.size(); i++){
            String text = values.get(i).getText();
            groups.add(text);
        }
        return groups;
    }
}
