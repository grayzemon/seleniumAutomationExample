package com.grayzemon.systemtest.steps;

import com.grayzemon.systemtest.utils.Pages;
import com.grayzemon.systemtest.utils.Screenshot;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.Map;
import java.util.NoSuchElementException;

import static com.grayzemon.systemtest.utils.DriverUtils.*;
import static com.grayzemon.systemtest.utils.LoggingFactory.*;

public class LoginTestStepDefinitions {

    private Pages pages;

    public LoginTestStepDefinitions(Pages pages) {
        this.pages = pages;
    }

    @Given("^I navigate to url \"([^\"]*)\"$")
    public void iNavigateToUrl(String url)  {
        pages.getLandingPage().enterSite(url);
    }


    @And("^I login to the site with the credentials \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iLoginToTheSiteWithTheCredentialsAnd(String username, String password)  {
        pages.getHomePage().selectLogin();
        pages.getLoginPage().login(username,password);
    }


    @Then("^the my account page will have text in a green box that will say \"([^\"]*)\"$")
    public void theMyAccountPageWillHaveTextInAGreenBoxThatWillSay(String expectedText) {
        String actualText = getWebDriver().findElement(By.className("msg_info")).getText();
        Assert.assertTrue(actualText.equalsIgnoreCase(expectedText));
    }


    @Then("^the homepage will have text that will say \"([^\"]*)\"$")
    public void theHomepageWillHaveTextThatWillSay(String expectedText) {
        Screenshot.takeScreenshot("Logged in homepage");
        Assert.assertEquals(expectedText,pages.getHomePage().getLogoutText());
    }

    @Then("^an error message will be returned containing \"([^\"]*)\" for \"([^\"]*)\"$")
    public void anErrorMessageWillBeReturnedContainingFor(String errorText, String scenario)  {
        Screenshot.takeScreenshot("Error message on login page for scenario of " + scenario);
        Map<String, WebElement> errorMap = pages.getLoginPage().getErrorText();
        try {
            log.info("Actual error: " + errorMap.get(scenario).getText());
            Assert.assertTrue(errorMap.get(scenario).getText().contains(errorText));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            Assert.fail("Unable to find expected error element");
        }
    }
}
