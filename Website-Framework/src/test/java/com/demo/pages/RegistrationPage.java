package com.demo.pages;

import com.demo.driver.WebDriverHandler;
import com.demo.utilities.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;


public class RegistrationPage extends BasePage {

    private static WebDriver driver;
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By dateOfBirth = By.id("dob");
    private final By address = By.id("address");
    private final By postcode = By.id("postcode");
    private final By city = By.id("city");
    private final By state = By.id("state");
    private final By country = By.id("country");
    private final By phone = By.id("phone");
    private final By emailField = By.id("email");
    private final By passwordField = By.xpath("//input[@id='password']");
    private final By submit = By.xpath("//button[@data-test='register-submit']");
    private final By registerButton = By.xpath("//a[@data-test='register-link' and @href='/auth/register']");

    private ConfigProperties newUserConfig;

    public void selectCountry() {
        Select dropdown = new Select(findElement(country));
        dropdown.selectByValue("BM");
        ((JavascriptExecutor) WebDriverHandler.getDriver()).executeScript("document.getElementById('country').blur();");

    }
    public RegistrationPage() throws IOException {
        newUserConfig = new ConfigProperties("resources/config/new-user.properties");
    }

    public void register(String username) throws InterruptedException {
        findElement(firstName).sendKeys(newUserConfig.getProperty("firstName"));
        findElement(lastName).sendKeys(newUserConfig.getProperty("lastName"));
        findElement(dateOfBirth).sendKeys(newUserConfig.getProperty("dateOfBirth"));
        findElement(address).sendKeys(newUserConfig.getProperty("address"));
        findElement(postcode).sendKeys(newUserConfig.getProperty("postcode"));
        findElement(city).sendKeys(newUserConfig.getProperty("city"));
        findElement(state).sendKeys(newUserConfig.getProperty("state"));
        findElement(phone).sendKeys(newUserConfig.getProperty("phone"));

        findElement(country).click();
        selectCountry();

        waitForElementToBeClickable(emailField);
        findElement(emailField).sendKeys(username);
        waitForElementToBeClickable(passwordField);
        findElement(passwordField).click();
        findElement(passwordField).sendKeys(newUserConfig.getProperty("password"));
        findElement(submit).click();
    }


    public void clickRegister() {
        findElement(registerButton).click();
    }

     public void registerNewUser(String email) throws InterruptedException {
       clickRegister();
        System.out.println("Registering user: " + email);
        register(email);
    }
}