package com.demo.tests;

import io.restassured.RestAssured;

import java.io.IOException;

public class BaseTest {
    public void setup() throws IOException {
        RestAssured.baseURI = "https://reqres.in/api";
    }
}
