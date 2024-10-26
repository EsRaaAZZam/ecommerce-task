package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public By getEmail() {
        return email;
    }

    public By getPasword() {
        return pasword;
    }

    private final By email = By.id("email");
    private final By pasword = By.xpath("//input[@data-test='password']");
    private final By loginBtn = By.xpath("//input[@data-test='login-submit']");
    private final By errorMessage = By.xpath("//div[@data-test='login-error']");

    public By getGoToHome() {
        return goToHome;
    }

    private final By goToHome = By.xpath(" //a[@data-test='nav-home']");

    public void login(String email ,String password) throws InterruptedException {
        findElement(this.email).sendKeys(email);
        waitForElementToBeClickable(pasword);
        findElement(pasword).sendKeys(password);
        findElement(loginBtn).click();
    }


    public void setGoToHomePage() {
        findElement(goToHome).click();
    }

    public WebElement getErrorMessage() {
        return findElement(errorMessage);
    }
}