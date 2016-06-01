package com.aframe.tests.gmail;

import com.aframe.pages.gmail.GmailInboxPage;
import com.aframe.pages.gmail.GmailLoginPage;
import com.aframe.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ivoloshyn on 5/20/2016.
 */
public class GmailTest extends BaseTest{

    GmailLoginPage gmailLoginPage = new GmailLoginPage(getWebdriver());
    GmailInboxPage gmailInboxPage = new GmailInboxPage(getWebdriver());

    @Test(enabled=true)
    public void verifyMessageIfNotExistingUsername(){
        gmailLoginPage.open();
        gmailLoginPage.typeUsername("notexistingnotexisting");
        gmailLoginPage.clickNextButton();
        Assert.assertTrue(gmailLoginPage.isMessageForNotExistingUsernameExists());
    }

    @Test(enabled=false)
    public void verifyPasswordFieldAppears(){
        gmailLoginPage.open();
        gmailLoginPage.typeUsername("vvvwix");
        gmailLoginPage.clickNextButton();
        Assert.assertTrue(gmailLoginPage.isPasswordFieldExists());
    }

    @Test(enabled=false)
    public void sendEmail(){
        gmailLoginPage.open();
        gmailLoginPage.typeUsername("vvvwix");
        gmailLoginPage.clickNextButton();
        gmailLoginPage.typePassword("W3lcome1");
        gmailLoginPage.clickSignInButton();
        gmailInboxPage.goToMailBox();
        gmailInboxPage.sendEmail("vvvwix@gmail.com", "subject5", "I am test body");
        Assert.assertTrue(gmailInboxPage.successfulSendMessageExist());
        Assert.assertTrue(gmailInboxPage.newMessageExistsInInbox("subject5"));
    }

}
