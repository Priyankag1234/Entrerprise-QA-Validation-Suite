package com.eqvs.pages;

import com.eqvs.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserManagementPage {
    private final WebDriver driver;

    private final By createButton = By.cssSelector("[data-test='create-user']");
    private final By emailInput = By.id("user-email");
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By saveButton = By.cssSelector("[data-test='save-user']");
    private final By successToast = By.cssSelector("[data-test='toast-success']");

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public UserManagementPage open(String baseUrl) {
        WaitUtils.clickable(driver, By.cssSelector("[data-route='admin-users']")).click();
        return this;
    }

    public UserManagementPage createUser(String email, String firstName, String lastName) {
        WaitUtils.clickable(driver, createButton).click();
        WaitUtils.visible(driver, emailInput).sendKeys(email);
        WaitUtils.visible(driver, firstNameInput).sendKeys(firstName);
        WaitUtils.visible(driver, lastNameInput).sendKeys(lastName);
        WaitUtils.clickable(driver, saveButton).click();
        return this;
    }

    public String successMessage() {
        return WaitUtils.visible(driver, successToast).getText();
    }
}


