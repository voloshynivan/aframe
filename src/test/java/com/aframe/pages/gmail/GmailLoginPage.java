package com.aframe.pages.gmail;

import com.aframe.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ivoloshyn on 5/20/2016.
 */
public class GmailLoginPage extends BasePage{
    protected static final By usernameField = By.id("Email");
    protected static final By passwordField = By.id("Passwd");
    protected static final By nextButton = By.id("next");
    protected static final By signInButton = By.id("signIn");
    protected static final By notExistingUsernameMessage = By.xpath(".//*[@id='errormsg_0_Email' and contains(text(), 'recognize that email.')]");

    public GmailLoginPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        //// TODO: 5/20/2016 Make it readable from property file
        driver.get("https://accounts.google.com/ServiceLogin");
    }

    public void typeUsername(String username){
        type(find(usernameField), username);
    }

    public void typePassword(String password){
        type(find(passwordField), password);
    }

    public void clickNextButton(){
        find(nextButton).click();
    }

    public void clickSignInButton(){
        find(signInButton).click();
    }

    public boolean isMessageForNotExistingUsernameExists(){
        return isElementPresent(notExistingUsernameMessage);
    }

    public boolean isPasswordFieldExists(){
        return isElementPresent(passwordField);
    }

}
