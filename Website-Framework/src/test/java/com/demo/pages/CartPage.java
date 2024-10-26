package com.demo.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {


    private final By checkoutButton = By.xpath("//button[@data-test='proceed-1']");
    private final By secondCheckoutButton = By.xpath("//button[@data-test='proceed-2']");

    public void proceedToCheckout() {
        waitForElementToBeClickable(checkoutButton);
        findElement(checkoutButton).click();
    }

    public void proceedToCheckout2() {
        waitForElementToBeClickable(secondCheckoutButton);
        findElement(secondCheckoutButton).click();
    }
}
