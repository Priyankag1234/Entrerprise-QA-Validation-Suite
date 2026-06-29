package com.eqvs.base;

import com.eqvs.utils.ConfigReader;
import java.nio.file.Path;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser) {
        baseUrl = resolveBaseUrl(ConfigReader.get("baseUrl"));
        driver = DriverFactory.create(browser);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String resolveBaseUrl(String configuredUrl) {
        if (!"local-demo".equalsIgnoreCase(configuredUrl)) {
            return configuredUrl;
        }

        return Path.of("..", "site", "demo", "index.html").toAbsolutePath().normalize().toUri().toString();
    }
}

