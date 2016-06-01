package com.aframe.pages.google;

import com.aframe.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by ivoloshyn on 5/19/2016.
 */
public class GoogleResultsPage extends GoogleBasePage {

    private final static By searchAreaLocator = By.id("center_col");


    public GoogleResultsPage(WebDriver driver){
        super(driver);
    }

    public boolean isAreaLocatorPresent(){
        return isElementPresent(searchAreaLocator);
    }

    public By getURLFromTheListOfResults(String URL){
        return By.xpath("//a[contains(@href,'" + URL + "')]");
    }

    public boolean isURLpresentInTheListOfResults(String URL){
        return isElementPresent(getURLFromTheListOfResults(URL));
    }

    public void clickOnTheURLFromSearchResults(String URL){
        find(getURLFromTheListOfResults(URL)).click();
    }

}
