package com.demo.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.demo.browser.Browser;
import com.demo.driver.WebDriverHandler;
import com.demo.pages.BasePage;
import com.demo.utilities.ConfigProperties;
import com.demo.utilities.TestUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class CheckoutTest extends BaseTest {
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeMethod
    @Parameters("browser")
    public void setUpWebsite() throws IOException {
        setupReport();
        initializeUserProperties();
        initializeWebDriver();
        navigateToLoginPage();
    }

    private void setupReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Complete Order Test");
    }

    private void initializeUserProperties() throws IOException {
        users = new ConfigProperties("resources/config/users.properties");
    }

    private void initializeWebDriver() throws IOException {
        String browserName = getBrowserName();
        String driverType = (browserName == null)
                ? new ConfigProperties("resources/config/configBrowser.properties").getProperty("driverType")
                : browserName;
        webDriverHandler = new WebDriverHandler(driverType);
        browser = new Browser();
    }

    private void navigateToLoginPage() {
        WebDriverHandler.getDriver().navigate().to("https://practicesoftwaretesting.com/auth/login");
    }

    @Test
    public void testCheckoutProcessWithExistingUser() throws InterruptedException {
        browser.applicationPage.loginPage.login(users.getEmail(), users.getPassword());
        BasePage.urlToContain("/account");
        test.info("User logged in successfully.");
        BasePage.waitForElementToBeClickable(browser.applicationPage.loginPage.getGoToHome());
        test.info("User logged in successfully.");
        browser.applicationPage.loginPage.setGoToHomePage();
        executeCheckoutProcess();
    }

    @Test
    public void testCheckoutProcessWithNonExistingUser() throws InterruptedException {
        String randomEmail = TestUtils.generateRandomEmail();
        browser.applicationPage.registrationPage.registerNewUser(randomEmail);
        BasePage.urlToContain("/auth/login");
        browser.applicationPage.loginPage.waitForElementToBeDisplayed(browser.applicationPage.loginPage.getPasword());
        browser.applicationPage.loginPage.login(randomEmail, users.getPassword());
        BasePage.urlToContain("/account");
        test.info("User logged in successfully.");
        BasePage.waitUntilPageIsLoaded();
       browser.applicationPage.loginPage.setGoToHomePage();
        executeCheckoutProcess();
    }


    private void executeCheckoutProcess() {
        try {
            test.info("Starting checkout process.");
            selectProduct(users.getProperty("product.name"));
            enterShippingInfo();
            completeOrder();
            validateSuccessMessage();
            test.pass("Checkout process completed successfully.");
        } catch (Exception e) {
            handleCheckoutError(e);
        }
    }

    private void selectProduct(String productName) {
        test.info("Selecting product: " + productName);
        browser.applicationPage.productPage.selectProduct(productName);
        browser.applicationPage.productPage.addToCart();
        test.info("Product added to cart.");
        browser.applicationPage.productPage.clickOncartBtn();
        test.info("Navigating to cart.");
        browser.applicationPage.cartPage.proceedToCheckout();
        test.info("Proceeding to checkout.");
        browser.applicationPage.cartPage.proceedToCheckout2();
        test.info("Proceeding to checkout.");
    }

    private void enterShippingInfo() {
        browser.applicationPage.checkoutPage.enterShippingInfo(
                users.getState(),
                users.getCountry(),
                users.getPostCode(),
                users.getAddress(),
                users.getCity()
        );
        test.info("Shipping information entered.");
    }

    private void completeOrder() {
        browser.applicationPage.checkoutPage.completeOrder("cash-on-delivery");
        test.info("Order completed using Cash on Delivery.");
    }

    private void validateSuccessMessage() {
        String successMessage = browser.applicationPage.checkoutPage.getSuccessMessage();
        test.info("Success Message: " + successMessage);
        Assert.assertEquals(successMessage, "Payment was successful", "Payment success message not as expected.");
    }

    private void handleCheckoutError(Exception e) {
        test.fail("Checkout process failed: " + e.getMessage());
        Assert.fail("Checkout process encountered an error: " + e.getMessage());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverHandler.closeDriver();
        WebDriverHandler.resetCache();
        extent.flush();
    }
}
