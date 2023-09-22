package com.agileprocrm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private const to remove access to this object
    private Driver(){}

    /*
    we make the webdriver private beacuse we want to close access from outside the class.
    we are making it static because we will use it in a static method.
     */

    //private static WebDriver driver; //default value= null

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    /*
    create a re-usable utility method which will return the same driver insatnce once we call it.
    if an instance doesn't exist it will create first, and then it will always return sane instance
     */

    public static WebDriver getDriver(){

        if(driverPool.get() ==null){

            /*
            we will read our browsertype from configuration.properties file
            this way we can control which browser is opened from outside our code.
             */
            String browserType= ConfigurationReader.getProperty("browser");

            /*
            depending on browsertype returned from the configuration.properties
            "swicth" statement will determine the "case" and open the matching browser.
             */

            switch (browserType){

                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                   // WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driverPool.get();
    }

    /*
    create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
         */

    public  static void  closeDriver(){
        if(driverPool.get()!=null){
            /*
            this line will terminete the currently existing driver completly. it will not exst going forward.
             */
            driverPool.get().quit();
            /*we assign the value back to null so that my singleton can create a newer oe if needed.
             */
            driverPool.remove();
        }
    }
}
