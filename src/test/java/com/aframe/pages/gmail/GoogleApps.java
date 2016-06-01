package com.aframe.pages.gmail;

        import com.aframe.pages.BasePage;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;

/**
 * Created by ivoloshyn on 5/20/2016.
 */
public class GoogleApps extends BasePage {

    protected final static By googleAppsIcon = By.xpath("//a[@title='Google apps']");
    protected final static By googleAppsMailIcon = By.xpath("//a[@class='gb_O' and contains(@href, 'mail.google.com/mail')]");

    public GoogleApps(WebDriver driver) {
        super(driver);
    }

    public void clickGoogleAppsMailIcon() {
        find(googleAppsIcon).click();
        find(googleAppsMailIcon).click();
    }

}

