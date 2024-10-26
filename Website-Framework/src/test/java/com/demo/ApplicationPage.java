package com.demo;

import com.demo.pages.*;

import java.io.IOException;

public class ApplicationPage extends BasePage {

    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public ProductPage productPage;
    public LoginPage loginPage;
    public RegistrationPage registrationPage;


    public ApplicationPage() throws IOException {
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        productPage = new ProductPage();
        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
    }

}