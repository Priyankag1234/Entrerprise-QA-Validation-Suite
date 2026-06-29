package com.eqvs.tests;

import com.eqvs.base.BaseTest;
import com.eqvs.pages.LoginPage;
import com.eqvs.pages.ReportsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReportsTests extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void managerCanGenerateReport() {
        new LoginPage(driver)
                .open(baseUrl)
                .loginAs("manager@corp.com", "Secure@2026QA");

        boolean displayed = new ReportsPage(driver)
                .open(baseUrl)
                .generate("2026-06-01", "2026-06-30")
                .reportIsDisplayed();

        Assert.assertTrue(displayed, "Report table should display for a valid date range");
    }

    @Test(groups = {"regression"})
    public void invalidDateRangeShowsValidationError() {
        new LoginPage(driver)
                .open(baseUrl)
                .loginAs("manager@corp.com", "Secure@2026QA");

        String error = new ReportsPage(driver)
                .open(baseUrl)
                .generate("2026-06-30", "2026-06-01")
                .dateErrorText();

        Assert.assertTrue(error.contains("Start date"), "Invalid date range should show validation feedback");
    }
}
