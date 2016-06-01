package com.aframe.tests.google;

import com.aframe.pages.google.GoogleInitPage;
import com.aframe.pages.google.GoogleResultsPage;
import com.aframe.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ivoloshyn on 5/19/2016.
 */
public class GoogleTest extends BaseTest {

    GoogleInitPage googleInitPage = new GoogleInitPage(getWebdriver());
    GoogleResultsPage googleResultsPage = new GoogleResultsPage(getWebdriver());

    @Test
    public void verifySearchAreaAppearsAfterPressingSearch(){
        googleInitPage.open();
        googleInitPage.searchFor("ANY_WORD");
        Assert.assertTrue(googleResultsPage.isAreaLocatorPresent(), "Search results Area is not present");
    }

    @Test
    public void verifyURLappearsInSearchResults(){
        googleInitPage.open();
        googleInitPage.searchFor("ANY_WORD");
        Assert.assertTrue(googleResultsPage.isURLpresentInTheListOfResults("urbandictionary.com"), "Search results Area is not present");

    }

    @Test
    public void clickURLInSearchResults(){
        googleInitPage.open();
        googleInitPage.searchFor("ANY_WORD");
        googleResultsPage.clickOnTheURLFromSearchResults("urbandictionary.com");
    }
}
