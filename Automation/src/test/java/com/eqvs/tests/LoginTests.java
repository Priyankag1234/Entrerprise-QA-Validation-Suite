package com.eqvs.tests;

import com.eqvs.base.BaseTest;
import com.eqvs.pages.DashboardPage;
import com.eqvs.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void validUserCanLogin() {
        DashboardPage dashboard = new LoginPage(driver)
                .open(baseUrl)
                .loginAs("valid.user@corp.com", "Secure@2026QA");

        Assert.assertTrue(dashboard.isLoaded(), "Dashboard should load after valid login");
    }

    @Test(groups = {"regression"})
    public void invalidPasswordShowsSecureError() {
        String error = new LoginPage(driver)
                .open(baseUrl)
                .attemptLogin("valid.user@corp.com", "wrong-password")
                .errorText();

        Assert.assertTrue(error.contains("Invalid"), "Login error should be clear but not reveal sensitive details");
    }
}
