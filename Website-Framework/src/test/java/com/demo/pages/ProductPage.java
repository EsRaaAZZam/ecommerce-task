package com.demo.pages;

import com.demo.driver.WebDriverHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private final By addToCartButton = By.id("btn-add-to-cart");
    private final By productLink = By.linkText("Your Product Name");
    private final By cartLink = By.xpath("//a[@data-test='nav-cart']");

    public WebElement getAddCartBtn() {
        return findElement(addToCartButton);
    }

    public WebElement getProductLink() {
        return findElement(productLink);
    }

    public void selectProduct(String productName) {
        By productLocator = By.xpath("//h5[@data-test='product-name' and normalize-space()='" + productName + "']");
        findElement(productLocator).click();
    }

    public void addToCart() {
        findElement(addToCartButton).click();
    }

    public void clickOncartBtn() {
        waitForElementToBeClickable(cartLink);
        ((JavascriptExecutor) WebDriverHandler.getDriver()).executeScript("arguments[0].click();", findElement(cartLink));
    }
}