package com.aframe.pages.google;

import com.aframe.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ivoloshyn on 5/19/2016.
 */
public class GoogleInitPage extends GoogleBasePage {

    public GoogleInitPage(WebDriver driver){
        super(driver);
    }
    
    public void open(){
        //// TODO: 5/19/2016 Make it readable from property file 
        driver.get("https://www.google.co.uk");
    }

}
