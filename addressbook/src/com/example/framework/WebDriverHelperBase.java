package com.example.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Emma on 6/27/2015.
 */
public abstract class WebDriverHelperBase extends HelperBase{

    protected WebDriver driver;
    private WebDriverWait wait;

    public WebDriverHelperBase(ApplicationManager manager){
        super(manager);
        this.driver = manager.getDriver();
        wait = new WebDriverWait(driver,10);
    }

    protected void type(By locator, String text){
        if(text != null){
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    protected void selectByText(By locator, String text){
        if(text != null){
            new Select(driver.findElement(locator)).selectByVisibleText(text);
        }
    }
}


