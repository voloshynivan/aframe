package com.aframe.pages.gmail;

import com.aframe.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivoloshyn on 5/20/2016.
 */
public abstract class GmailBasePage extends BasePage {

    protected static final By composeButton = By.xpath("//*[text()='COMPOSE']");
    protected static final By toField = By.name("to");
    protected static final By subjectField = By.name("subjectbox");
    protected static final By bodyField = By.xpath("//div[@aria-label='Message Body']");
    protected static final By sendButton = By.xpath("//*[text()='Send']");
    protected static final By successfulMessage = By.xpath("//*[contains(text(), 'Your message has been sent.')]");


    GoogleApps googleApps = new GoogleApps(driver);

    public GmailBasePage(WebDriver driver) {
        super(driver);
    }

    public GmailBasePage goToMailBox() {
        googleApps.clickGoogleAppsMailIcon();
        return this;
    }

    public void clickComposeButton() {
        find(composeButton).click();
    }

    public void clickSendButton() {
        find(sendButton).click();
    }

    public void typeTo(String to) {
        type(find(toField), to);
    }

    public void typeSubject(String subject) {
        type(find(subjectField), subject);
    }

    public void typeBody(String body) {
        type(find(bodyField), body);
    }

    public void sendEmail(String to, String subject, String body) {
        clickComposeButton();
        typeTo(to);
        typeSubject(subject);
        typeBody(body);
        clickSendButton();
    }

    public boolean successfulSendMessageExist() {
        return isElementPresent(successfulMessage);
    }

    public boolean newMessageExistsInInbox(String subj) {
        WebElement newDynamicMessage = (new WebDriverWait(driver, 180))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody//b[text()='" + subj + "']")));
        return newDynamicMessage.isDisplayed();

    }
}
