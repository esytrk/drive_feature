package com.agileprocrm.step_definitions;

import com.agileprocrm.pages.DrivePage;
import com.agileprocrm.pages.LoginPage;
import com.agileprocrm.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class DriveStepDefs {


    @Given("{string} user logins the website")
    public void user_logins_the_website(String user) {

        LoginPage loginPage=new LoginPage();
        loginPage.login(user);

        BrowserUtils.sleep(3);

    }
    @When("User clicks on the {string} module")
    public void user_clicks_on_the_module(String module) {

        DrivePage.navigateToModule(module);
        BrowserUtils.sleep(3);

    }
    @Then("{string} module is displayed")
    public void module_is_displayed(String subModule) {
        WebElement subModuleElement = DrivePage.getSubModule(subModule);
        System.out.println(subModuleElement.getText());

        Assert.assertTrue(subModuleElement.isDisplayed());


    }




}