package com.aframe.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by ivoloshyn on 5/18/2016.
 */

public abstract class BaseTest {

    protected static WebDriver driver;

    DesiredCapabilities capability = DesiredCapabilities.firefox();

    //// TODO: 5/19/2016 read property and initialize appropriate driver (chrome, firefox or IE)
    protected WebDriver getWebdriver(){
        /*
        if (driver == null) {
            driver =  new FirefoxDriver();
            driver.manage().deleteAllCookies();
            //// TODO: 5/19/2016 - Add implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        }
        */
        if (driver == null) {
            try {
                driver =  new RemoteWebDriver(new URL("http://172.23.73.110:4444/wd/hub"), capability);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().deleteAllCookies();
            //// TODO: 5/19/2016 - Add implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        }
        return driver;
    }

    @BeforeTest
    public void setUpTest(){

    }

    @AfterTest
    public void tearDown(){
        System.out.println("Tear down is executed");
        driver.close();

    }

}
