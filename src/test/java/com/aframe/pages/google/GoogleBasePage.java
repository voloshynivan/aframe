package com.aframe.pages.google;

import com.aframe.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ivoloshyn on 5/19/2016.
 */
public abstract class GoogleBasePage extends BasePage {
    protected final static By searchFieldLocator = By.name("q");
    protected final static By searchButtonLocator = By.name("btnG");

    public GoogleBasePage(WebDriver driver){
        super(driver);
    }

    public void clickSearchButton(){
        find(searchButtonLocator).click();
    }

    public void typeToSearch(String searchCriteria){
        type(find(searchFieldLocator), searchCriteria);
    }

    public GoogleResultsPage searchFor(String searchCriteria){
        typeToSearch(searchCriteria);
        clickSearchButton();
        return new GoogleResultsPage(driver);
    }

}
