package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    private final By addressField = By.id("address");
    private final By cityField = By.id("city");
    private final By state = By.id("state");
    private final By postCode = By.id("postcode");
    private final By country = By.id("country");
    private final By continueButton = By.cssSelector("button[data-test='proceed-3']");
    private final By completeOrderButton = By.xpath("//button[@data-test='finish']");
    private final By successMessageLocator = By.className("help-block");
    private final By paymentMethodDropdown = By.id("payment-method");


    public void enterShippingInfo(String firstName, String lastName, String email, String address, String city) {
        findElement(state).clear();
        findElement(postCode).clear();
        findElement(country).clear();
        findElement(addressField).clear();
        findElement(cityField).clear();
        findElement(state).sendKeys(firstName);
        findElement(country).sendKeys(lastName);
        findElement(postCode).sendKeys(email);
        findElement(addressField).sendKeys(address);
        findElement(cityField).sendKeys(city);

    }

    public void selectPaymentMethod(String paymentMethod) {
        Select dropdown = new Select(findElement(paymentMethodDropdown));
        dropdown.selectByValue(paymentMethod);
    }

    public String getSuccessMessage() {

        WebElement successMessageElement = findElement(successMessageLocator);
        return successMessageElement.getText();
    }

    public void completeOrder(String paymentMethod) {
        findElement(continueButton).click();
        selectPaymentMethod(paymentMethod);
        findElement(completeOrderButton).click();
    }
}
