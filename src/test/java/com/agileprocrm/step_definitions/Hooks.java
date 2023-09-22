package com.agileprocrm.step_definitions;

import com.agileprocrm.utilities.BrowserUtils;
import com.agileprocrm.utilities.ConfigurationReader;
import com.agileprocrm.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setupMethod(){
        System.out.println("--> @Before: Running Before Each Scenario");
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("--> @After: Running After Each Scenario");

        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }


}


