package com.demo.utilities;

import java.util.Random;

public class TestUtils {
    private static final String EMAIL_DOMAIN = "@example.com";
    private static final Random RANDOM = new Random();

    public static String generateRandomEmail() {
        int randomNum = RANDOM.nextInt(1000);
        return "user" + randomNum + EMAIL_DOMAIN;
    }


}
