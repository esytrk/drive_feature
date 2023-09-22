package com.agileprocrm.pages;

import com.agileprocrm.utilities.ConfigurationReader;
import com.agileprocrm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(name = "USER_LOGIN")
    public WebElement username;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    public static String getUser(String user){
        String username="";
        if(user.equals( "HR")){
            username= ConfigurationReader.getProperty("hrUsername");
        } else if (user.equals("Marketing")) {
            username=ConfigurationReader.getProperty("marketingUsername");
        }else if (user.equals("HelpDesk")) {
            username= ConfigurationReader.getProperty("helpdeskUsername");

    }
        return username;

    }



    public  void login(String userType){

        /*
        String userName = LoginPage.getUser(user);
        System.out.println(userName);

        LoginPage loginPage=new LoginPage();
        loginPage.username.sendKeys(userName);
        loginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.submit.click();
         */

        // User bilgisini Conf.readerdan oku
        String userInfo = getUser(userType);
        System.out.println(userInfo);

        //login stepleri
        username.sendKeys(userInfo);
        password.sendKeys(ConfigurationReader.getProperty("password"));
        submit.click();




    }








}



