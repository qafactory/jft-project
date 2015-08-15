package com.example.tests;

import com.example.framework.ApplicationManager;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Created by Emma on 7/19/2015.
 */
public class ContactDataGenerator extends TestBase{

    public static void main(String[] args) throws IOException{
        if (args.length < 3){
            System.out.println("Please specify parameters: <amount of test data> <file> <format>");
            return;
        }

        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        if (file.exists()){
            System.out.println("File already exists, please remove it manually: " + file);
            return;
        }

        List<ContactData> contacts = generateRandomContacts(amount);

        if (format.equals("csv")){
            saveContactsToCsvFile(contacts, file);
        }else if(format.equals("xml")){
            saveContactsToXmlFile(contacts, file);
        }else {
            System.out.println("Unknown format " + format);
            return;
        }
    }

    //----------------------------------------------------------------------

    private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (ContactData contact: contacts){
            writer.write(contact.getFirstname() + ", " + contact.getLastname() + ", " + contact.getAddress()
                    + ", " + contact.getHomephone() + ", " + contact.getMobilephone() + ", " + contact.getWorkphone()
                    + ", " + contact.getEmail1() + ", " + contact.getEmail2() + ", " + contact.getBday()
                    + ", " + contact.getBmonth() + ", " + contact.getByear() + ", " + contact.getGroup()
                    + ", " + contact.getAddress2() + ", " + contact.getPhone2() +",!" + "\n");
        }
        writer.close();
    }

    private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException{
        XStream xstream = new XStream();
        xstream.alias("contact", ContactData.class);
        String xml = xstream.toXML(contacts);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    public static List<ContactData> loadContactsFromXmlFile(File file) throws IOException{
        XStream xstream = new XStream();
        xstream.alias("contact", ContactData.class);
        return (List<ContactData> ) xstream.fromXML(file);
    }

    public static List<ContactData> generateRandomContacts(int amount) {
        List<ContactData> list = new ArrayList<ContactData>();
        for (int i = 0; i < amount; i++){
            ContactData contact = new ContactData()
                    .withFirstname(generateRandomString())
                    .withLastname(generateRandomString())
                    .withAddress(generateRandomString())
                    .withHomePhone(generateRandomString())
                    .withMobilePhone(generateRandomString())
                    .withWorkPhone(generateRandomString())
                    .withEmail1(generateRandomString())
                    .withEmail2(generateRandomString())
                    .withBday(generateRandomDaySelection())
                    .withBmonth(generateRandomMonthSelection())
                    .withByear(generateRandomString())
                    .withGroup(generateRandomGroupSelection())
                    .withAddress2(generateRandomString())
                    .withPhone2(generateRandomString());
            list.add(contact);
        }
        return list;
    }

    public static String generateRandomString(){
        Random rnd = new Random();
        if (rnd.nextInt(3) == 0){
            return "";
        }else{
            return "name" + rnd.nextInt();
        }
    }

    public static String generateRandomDaySelection(){
        Random rnd = new Random();
        int index = rnd.nextInt(31)+1;
        return Integer.toString(index);
    }

    public static String generateRandomMonthSelection(){
        String months[] = { "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December" };
        Random rnd = new Random();
        int index = rnd.nextInt(months.length);
        return months[index];
    }

    private static String generateRandomGroupSelection() {
        String configFile = System.getProperty("configFile", "chrome.properties");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader((new File(configFile))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ApplicationManager app = new ApplicationManager(properties);

        List<String> groups = new ArrayList<>();
        groups = app.getHibernateHelper().groupNames();
        Random rnd = new Random();
        int index = rnd.nextInt(groups.size());
        return groups.get(index);
    }
}
