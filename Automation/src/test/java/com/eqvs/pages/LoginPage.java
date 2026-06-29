package com.eqvs.pages;

import com.eqvs.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("[data-test='login-submit']");
    private final By errorMessage = By.cssSelector("[data-test='login-error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public DashboardPage loginAs(String email, String password) {
        typeCredentials(email, password);
        WaitUtils.clickable(driver, loginButton).click();
        return new DashboardPage(driver);
    }

    public LoginPage attemptLogin(String email, String password) {
        typeCredentials(email, password);
        WaitUtils.clickable(driver, loginButton).click();
        return this;
    }

    public String errorText() {
        return WaitUtils.visible(driver, errorMessage).getText();
    }

    private void typeCredentials(String email, String password) {
        WaitUtils.visible(driver, emailInput).clear();
        WaitUtils.visible(driver, emailInput).sendKeys(email);
        WaitUtils.visible(driver, passwordInput).clear();
        WaitUtils.visible(driver, passwordInput).sendKeys(password);
    }
}
