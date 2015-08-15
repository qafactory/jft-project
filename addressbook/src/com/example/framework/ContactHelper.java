package com.example.framework;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends WebDriverHelperBase {

    public static boolean CREATION   = true;
    public static boolean MODIFICATION = false;
    
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public ContactHelper createContact(ContactData contact){
        manager.navigateTo().mainPage();
        initContactCreation();
        fillContactForm(contact, CREATION);
        submitContactCreation();
        returnToHomePage();
        manager.getModel().addContact(contact);
        return this;
    }

    public ContactHelper editContact(int index, ContactData contact){
        manager.navigateTo().mainPage();
        initContactEditing(index);
        fillContactForm(contact, MODIFICATION);
        submitContactModification();
        returnToHomePage();
        manager.getModel().removeContact(index).addContact(contact);
        return this;
    }

    public ContactHelper modifyContact(int index, ContactData contact){
        manager.navigateTo().mainPage();
        viewContactDetails(index);
        initContactModification();
        fillContactForm(contact, MODIFICATION);
        submitContactModification();
        returnToHomePage();
        manager.getModel().removeContact(index).addContact(contact);
        return this;
    }

    public ContactHelper deleteContactByEdit(int index){
        manager.navigateTo().mainPage();
        initContactEditing(index);
        submitContactDeletion();
        manager.getModel().removeContact(index);
        returnToHomePage();
        return this;
    }

    public ContactHelper deleteContactByModify(int index){
        manager.navigateTo().mainPage();
        viewContactDetails(index);
        initContactModification();
        submitContactDeletion();
        returnToHomePage();
        manager.getModel().removeContact(index);
        return this;
    }

    //-----------------------------------------------------------------------------

    public SortedListOf<ContactData> getUiContacts() {

        SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
        manager.navigateTo().mainPage();
        List<WebElement> entries =  driver.findElements(By.xpath("//tbody/tr[@name='entry']/td[2]"));
        for (WebElement entry: entries){ContactData contact = new ContactData();
            String name = entry.getText();
            contacts.add(new ContactData().withLastname(name));
        }
        return contacts;
    }

    public ContactHelper initContactCreation() {
        click(By.linkText("add new"));
        return this;
    }

    public ContactHelper fillContactForm(ContactData contact, boolean formType) {
        type(By.name("firstname"), contact.getFirstname());
        type(By.name("lastname"), contact.getLastname());
        type(By.name("address"), contact.getAddress());
        type(By.name("home"), contact.getHomephone());
        type(By.name("mobile"), contact.getMobilephone());
        type(By.name("work"), contact.getWorkphone());
        type(By.name("email"), contact.getEmail1());
        type(By.name("email2"), contact.getEmail2());
        selectByText(By.name("bday"), contact.getBday());
        selectByText(By.name("bmonth"), contact.getBmonth());
        type(By.name("byear"), contact.getByear());
        if(formType == CREATION){
            selectByText(By.name("new_group"), contact.getGroup());
        } else {
            if(driver.findElements(By.name("new_group")).size() != 0){
                throw new Error("Group selector exists in contact modification form");
            }
        }
        type(By.name("address2"), contact.getAddress2());
        type(By.name("phone2"), contact.getPhone2());
        return this;
    }

    public ContactHelper submitContactCreation() {
        click(By.name("submit"));
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
        return this;
    }

    public ContactHelper submitContactDeletion() {
        click(By.xpath("//input[@value='Delete']"));
        return this;
    }

    public ContactHelper returnToHomePage() {
        click(By.linkText("home page"));
        return this;
    }
}
