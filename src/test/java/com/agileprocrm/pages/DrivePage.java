package com.agileprocrm.pages;

import com.agileprocrm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DrivePage extends BasePage {


    @FindBy(xpath = "(//span[normalize-space()='My Drive'])[2]")
    public WebElement myDrive;

    @FindBy(xpath = "(//span[normalize-space()='All Documents'])[2]")
    public WebElement allDocuments;

    public static WebElement getSubModule(String subModule){

        String locator="(//span[normalize-space()='"+subModule+"'])[2]";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        return element;
    }
}
