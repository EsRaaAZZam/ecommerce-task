package com.demo.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class ApiTests extends BaseTest {


    @BeforeClass
    public void setup() throws IOException {
        super.setup();
        String filePath = "resources/config/CreatedUserIds.txt";
        if (!Files.exists(Paths.get(filePath))) {
            Files.createDirectories(Paths.get("resources/config"));
            Files.createFile(Paths.get(filePath));
        }
    }


    @Test
    @Description("Test to create a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void testCreateUser() throws IOException {
        String requestBody = new String(Files.readAllBytes(Paths.get("resources/config/CreateUser.json")));
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 201);

        String userId = response.jsonPath().getString("id");
        Assert.assertNotNull(userId, "User ID should not be null");
        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe");
        Assert.assertEquals(response.jsonPath().getString("job"), "Software Engineer");
        Assert.assertNotNull(response.jsonPath().getString("id"));
        System.out.println("ID " + response.jsonPath().getString("id"));
        Set<String> existingIds = new HashSet<>(Files.readAllLines(Paths.get("resources/config/CreatedUserIds.txt")));
        Assert.assertFalse(existingIds.contains(userId), "User ID is not unique: " + userId);
        Files.write(Paths.get("resources/config/CreatedUserIds.txt"), (userId + "\n").getBytes(), StandardOpenOption.APPEND);
    }
}
