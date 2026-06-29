package com.eqvs.pages;

import com.eqvs.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private final WebDriver driver;

    private final By pageTitle = By.cssSelector("[data-test='dashboard-title']");
    private final By currentUser = By.cssSelector("[data-test='current-user']");
    private final By adminWidget = By.cssSelector("[data-test='admin-widget']");
    private final By logoutButton = By.cssSelector("[data-test='logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return WaitUtils.visible(driver, pageTitle).isDisplayed();
    }

    public String currentUserName() {
        return WaitUtils.visible(driver, currentUser).getText();
    }

    public boolean adminWidgetIsVisible() {
        return WaitUtils.visible(driver, adminWidget).isDisplayed();
    }

    public LoginPage logout() {
        WaitUtils.clickable(driver, logoutButton).click();
        return new LoginPage(driver);
    }
}
