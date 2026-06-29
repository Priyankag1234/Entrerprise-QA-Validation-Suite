package com.eqvs.tests;

import com.eqvs.base.BaseTest;
import com.eqvs.pages.LoginPage;
import com.eqvs.pages.UserManagementPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserManagementTests extends BaseTest {
    @Test(groups = {"smoke", "regression"})
    public void adminCanCreateUser() {
        new LoginPage(driver)
                .open(baseUrl)
                .loginAs("admin@corp.com", "Secure@2026QA");

        String message = new UserManagementPage(driver)
                .open(baseUrl)
                .createUser("new.user@corp.com", "New", "User")
                .successMessage();

        Assert.assertTrue(message.contains("created"), "Create user success message should appear");
    }
}
