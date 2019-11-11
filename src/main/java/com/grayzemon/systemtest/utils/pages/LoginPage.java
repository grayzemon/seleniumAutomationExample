package com.grayzemon.systemtest.utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.grayzemon.systemtest.utils.DriverUtils.getWebDriver;

public class LoginPage {

    @FindBy(xpath = "//*[@id='js-cookie-notice']/div/div/button/span")
    private WebElement acceptCookie;

    @FindBy(id = "username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(id = "submitAction")
    private WebElement submit;


    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public void login(String username,String password) {
        acceptCookie.click();
        email.sendKeys(username);
        loginPassword.sendKeys(password);
        submit.click();
    }


}
