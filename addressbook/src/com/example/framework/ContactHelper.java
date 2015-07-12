package com.example.framework;

import com.example.tests.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

    public static boolean CREATION   = true;
    public static boolean MODIFICATION = false;
    
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    List<ContactData> cashedContacts;

    public List<ContactData> getContacts() {
        if(cashedContacts == null){
            rebuildCache();
        }
        return cashedContacts;
    }

    private void rebuildCache() {
        cashedContacts = new ArrayList<ContactData>();
        List<WebElement> entries =  driver.findElements(By.xpath("//tbody/tr[@name='entry']/td[2]"));
        for (WebElement entry: entries){
            ContactData contact = new ContactData();
            String name = entry.getText();
            contact.lastname = name;
            cashedContacts.add(contact);
        }
    }

    public void submitContactCreation() {
        click(By.name("submit"));
        cashedContacts = null;
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contact, boolean formType) {
        type(By.name("firstname"), contact.firstname);
        type(By.name("lastname"), contact.lastname);
        type(By.name("address"), contact.address);
        type(By.name("home"), contact.homephone);
        type(By.name("mobile"), contact.mobilephone);
        type(By.name("work"), contact.workphone);
        type(By.name("email"), contact.email1);
        type(By.name("email2"), contact.email2);
        selectByText(By.name("bday"), contact.bday);
        selectByText(By.name("bmonth"), contact.bmonth);
        type(By.name("byear"), contact.byear);
        if(formType == CREATION){
            selectByText(By.name("new_group"), contact.group);
        } else {
            if(driver.findElements(By.name("new_group")).size() != 0){
                throw new Error("Group selector exists in contact modification form");
            }
        }
        type(By.name("address2"), contact.address2);
        type(By.name("phone2"), contact.phone2);
    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
        cashedContacts = null;
    }

    public void initContactEditing(int index){
        click(By.xpath("(//img[@title='Edit'])[" + (index+1) + "]"));
    }

    public void submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
        cashedContacts = null;
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
