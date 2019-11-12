package com.grayzemon.systemtest.utils.pages;

import com.grayzemon.systemtest.utils.Screenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;

import static com.grayzemon.systemtest.utils.DriverUtils.getWebDriver;

public class LoginPage {

    public static final String MISSING_USERNAME = "Missing Username";
    public static final String MISSING_PASSWORD = "Missing Password";
    public static final String INVALID_LOGIN = "Invalid Login";
    @FindBy(xpath = "//*[@id='js-cookie-notice']/div/div/button/span")
    private WebElement acceptCookie;

    @FindBy(id = "username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(id = "submitAction")
    private WebElement submit;

    @FindBy(xpath = "//*[@id='parsley-id-5']/li")
    private WebElement userNameError;

    @FindBy(xpath = "//*[@id='parsley-id-7']/li")
    private WebElement passwordError;

    @FindBy(xpath = "/html/body/div[2]/section/div[1]/span")
    private WebElement invalidLogin;

    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public void login(String username,String password) {
        acceptCookie.click();
        email.clear();
        email.sendKeys(username);
        loginPassword.clear();
        loginPassword.sendKeys(password);
        submit.click();
    }

    public Map<String, WebElement>  getErrorText() {
        Map<String, WebElement> errorMap = new HashMap<>();
        errorMap.put(MISSING_USERNAME,userNameError);
        errorMap.put(MISSING_PASSWORD, passwordError);
        errorMap.put(INVALID_LOGIN, invalidLogin);
        return errorMap;
    }

}
