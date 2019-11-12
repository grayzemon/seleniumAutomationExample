package com.grayzemon.systemtest.utils;

import com.grayzemon.systemtest.utils.pages.HomePage;
import com.grayzemon.systemtest.utils.pages.LandingPage;
import com.grayzemon.systemtest.utils.pages.LoginPage;


public class Pages {

    private LandingPage landingPage;
    private HomePage homePage;
    private LoginPage loginPage;

    public Pages() {
        landingPage = new LandingPage();
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    public LandingPage getLandingPage() {
        return landingPage;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
