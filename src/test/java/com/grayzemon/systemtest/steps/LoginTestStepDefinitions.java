package com.grayzemon.systemtest.steps;

import com.grayzemon.systemtest.utils.TestContext;
import com.grayzemon.systemtest.utils.pages.HomePage;
import com.grayzemon.systemtest.utils.pages.LandingPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;

import javax.naming.Context;

import static com.grayzemon.systemtest.utils.DriverUtils.*;

public class LoginTestStepDefinitions {

    private TestContext pages;

    public LoginTestStepDefinitions(TestContext context) {
        this.pages = context;
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
        Assert.assertEquals(expectedText,pages.getHomePage().getLogoutText());
    }
}
