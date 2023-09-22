package com.agileprocrm.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

       /*
    this method will accept int (in seconds)
    and execute Thread.sleep method for given duration
     */

    public static  void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){
            System.out.println();
        }
    }

    public static  void switchWindowAndVerify (String expectedInURL, String expectedInTitle){

        //4. Create a logic to switch to the tab where Etsy.com is open

        Set<String> allWindowsHandles= Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());

            if(Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        // 5. Assert:Title contains“Etsy”

        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals( expectedTitle,Driver.getDriver().getTitle());
    }

    public static void verifyTitleContains(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    //this method accepts WebElemnt target,
    // and waits for that WebElement to not to be displayed on the page.

    public static void waitForInVisibilityOf(WebElement target){

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    //this method accepts String Title
    // and waits for that Title to contain given String value.

    public static void waitForTitleContains(String title){

        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
    }

    //this method accpets a dropdown element and returns a List<String> that contains all options vaues as String

    public static List<String> dropdownOptions_as_STRING (WebElement dropdownElement) {

        Select month = new Select(dropdownElement);

        //Storing all the ACTUAL options ,into a list of WebElements

        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        //creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //looping through the list<webelement> getting all options texts and storing them into list<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {
            actualMonth_as_STRING.add(each.getText());
        }

        return actualMonth_as_STRING;

    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equals(attributeValue)){
                each.click();
            }
        }
    }



}
