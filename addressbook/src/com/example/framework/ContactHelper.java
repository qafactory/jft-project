package com.example.framework;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
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

    private SortedListOf<ContactData> cashedContacts;

    public SortedListOf<ContactData> getContacts() {
        if(cashedContacts == null){
            rebuildCache();
        }
        return cashedContacts;
    }

    private void rebuildCache() {
        cashedContacts = new SortedListOf<ContactData>();
        manager.navigateTo().mainPage();
        List<WebElement> entries =  driver.findElements(By.xpath("//tbody/tr[@name='entry']/td[2]"));
        for (WebElement entry: entries){ContactData contact = new ContactData();
            String name = entry.getText();
            cashedContacts.add(new ContactData().withLastname(name));
        }
    }

    public ContactHelper createContact(ContactData contact){
        manager.navigateTo().mainPage();
        initContactCreation();
        fillContactForm(contact, CREATION);
        submitContactCreation();
        returnToHomePage();
        rebuildCache();
        return this;
    }

    public ContactHelper editContact(int index, ContactData contact){
        manager.navigateTo().mainPage();
        initContactEditing(index);
        fillContactForm(contact, MODIFICATION);
        submitContactModification();
        returnToHomePage();
        return this;
    }

    public ContactHelper modifyContact(int index, ContactData contact){
        manager.navigateTo().mainPage();
        viewContactDetails(index);
        initContactModification();
        fillContactForm(contact, MODIFICATION);
        submitContactModification();
        returnToHomePage();
        return this;
    }

    public ContactHelper deleteContactByEdit(int index){
        manager.navigateTo().mainPage();
        initContactEditing(index);
        submitContactDeletion();
        returnToHomePage();
        return this;
    }

    public ContactHelper deleteContactByModify(int index){
        manager.navigateTo().mainPage();
        viewContactDetails(index);
        initContactModification();
        submitContactDeletion();
        returnToHomePage();
        return this;
    }

    //-----------------------------------------------------------------------------

    public ContactHelper initContactCreation() {
        click(By.linkText("add new"));
        return this;
    }

    public ContactHelper fillContactForm(ContactData contact, boolean formType) {
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
        return this;
    }

    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
        cashedContacts = null;
        return this;
    }

    public ContactHelper initContactEditing(int index){
        click(By.xpath("(//img[@title='Edit'])[" + (index + 1) + "]"));
        return this;
    }

    public ContactHelper viewContactDetails(int index) {
        click(By.xpath("(//img[@title='Details'])[" + (index + 1) + "]"));
        return this;
    }

    public ContactHelper initContactModification() {
        click(By.xpath("//input[@name='modifiy']"));
        return this;
    }

    public ContactHelper submitContactModification() {
        click(By.xpath("//input[@value='Update']"));
        cashedContacts = null;
        return this;
    }

    public ContactHelper submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
        cashedContacts = null;
        return this;
    }

    public ContactHelper returnToHomePage() {
        click(By.linkText("home page"));
        return this;
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
