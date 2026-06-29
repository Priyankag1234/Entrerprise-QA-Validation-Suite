package com.eqvs.pages;

import com.eqvs.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReportsPage {
    private final WebDriver driver;

    private final By startDate = By.id("start-date");
    private final By endDate = By.id("end-date");
    private final By generateButton = By.cssSelector("[data-test='generate-report']");
    private final By reportTable = By.cssSelector("[data-test='report-table']");
    private final By dateError = By.cssSelector("[data-test='date-error']");

    public ReportsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ReportsPage open(String baseUrl) {
        WaitUtils.clickable(driver, By.cssSelector("[data-route='reports']")).click();
        return this;
    }

    public ReportsPage generate(String from, String to) {
        WaitUtils.visible(driver, startDate).sendKeys(from);
        WaitUtils.visible(driver, endDate).sendKeys(to);
        WaitUtils.clickable(driver, generateButton).click();
        return this;
    }

    public boolean reportIsDisplayed() {
        return WaitUtils.visible(driver, reportTable).isDisplayed();
    }

    public String dateErrorText() {
        return WaitUtils.visible(driver, dateError).getText();
    }
}


