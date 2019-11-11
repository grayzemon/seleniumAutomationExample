package com.grayzemon.systemtest.utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.grayzemon.systemtest.utils.DriverUtils.getWebDriver;

public class HomePage {

    @FindBy(xpath = "//*[@id='sso-login']/span")
    private WebElement login;

    @FindBy(id = "sso-logout")
    private WebElement logout;

    public HomePage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public void selectLogin() {
        login.click();
    }

    public String getLogoutText() {
        return logout.getText();
    }
}
