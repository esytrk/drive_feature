package com.agileprocrm.pages;

import com.agileprocrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    ////span[normalize-space()='Drive']

    public static void navigateToModule(String moduleName){

        String locator="//span[normalize-space()='"+moduleName+"']";

        Driver.getDriver().findElement(By.xpath(locator)).click();
    }
}
