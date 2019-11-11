package com.grayzemon.systemtest.utils.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.grayzemon.systemtest.utils.DriverUtils.*;

public class LandingPage {

    @FindBy(xpath = "//*[@id='splash-menu']/ul/li[1]/a/span")
    private WebElement enterSite;

    @FindBy(xpath = "//*[@id='js-cookie-notice']/div/div/div/div/button[1]")
    private WebElement acceptCookie;


    public LandingPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public void enterSite(String url){
        getWebDriver().get(url);
        acceptCookie.click();
        enterSite.click();
    }
}
