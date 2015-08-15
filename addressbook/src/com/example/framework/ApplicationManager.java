package com.example.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Emma on 6/27/2015.
 */
public class ApplicationManager {

    private WebDriver driver;
    public String baseUrl;

    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private HibernateHelper hibernateHelper;
    private Properties properties;

    private ApplicationModel model;

    public ApplicationManager(Properties properties){
        this.properties = properties;
        model = new ApplicationModel();
        model.setGroups(getHibernateHelper().listGroups());
        model.setContacts(getHibernateHelper().listContacts());
    }

    public void stop() {
        driver.quit();
    }

    public ApplicationModel getModel(){
        return model;
    }

    public NavigationHelper navigateTo(){
        if(navigationHelper == null){
            navigationHelper = new NavigationHelper(this);
        }
        return navigationHelper;
    }

    public GroupHelper getGroupHelper(){
        if(groupHelper == null){
            groupHelper = new GroupHelper(this);
        }
        return groupHelper;
    }

    public ContactHelper getContactHelper(){
        if(contactHelper == null){
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public HibernateHelper getHibernateHelper() {
        if(hibernateHelper == null){
            hibernateHelper = new HibernateHelper(this);
        }
        return hibernateHelper;
    }

    public WebDriver getDriver() {
        if(driver == null){
            String browser = properties.getProperty("browser");
            if (browser.equals("firefox")){
                driver = new FirefoxDriver();
            } else if (browser.equals("chrome")){
                driver = new ChromeDriver();
            }else if (browser.equals("ie")) {
                driver = new InternetExplorerDriver();
            }else {
                throw new Error("Unsupported browser: " + browser);
            }
            baseUrl = properties.getProperty("baseUrl");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(baseUrl);
        }
        return driver;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

}
