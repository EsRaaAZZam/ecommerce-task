package com.demo.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.io.IOException;

public class WebDriverHandler {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private final String driverType;

    public WebDriverHandler(String browserName) throws IOException {
        this.driverType = browserName;
        System.out.println("Browser name: " + driverType);
        initializeDriver(driverType);
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void closeDriver() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.quit();
            threadLocalDriver.remove();
        }
    }

    public static void resetCache() {
        WebDriver driver = threadLocalDriver.get();
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }

    private void initializeDriver(String browserType) throws IOException {
        System.out.println("Initializing WebDriver for browser: " + browserType);
        WebDriver driver = null;

        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                break;

            case "safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                driver.manage().window().maximize();
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                break;

            default:
                throw new IllegalArgumentException("Browser type not supported: " + browserType);
        }

        threadLocalDriver.set(driver);
    }
}
