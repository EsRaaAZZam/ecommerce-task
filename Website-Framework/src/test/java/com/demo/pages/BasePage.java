package com.demo.pages;

import com.demo.driver.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public BasePage() {
    }


    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverHandler.getDriver(), Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void urlToContain(String word) {

        WebDriverWait wait = new WebDriverWait(WebDriverHandler.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(word));
    }

    public WebElement findElement(By locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverHandler.getDriver(), Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return WebDriverHandler.getDriver().findElement(locator);
    }
    public WebElement waitForElementToBeDisplayed(By locator) {
        WebDriverWait wait = new WebDriverWait(WebDriverHandler.getDriver(), Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void waitUntilPageIsLoaded() {
        WebDriverWait wait = new WebDriverWait(WebDriverHandler.getDriver(), Duration.ofSeconds(35));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
