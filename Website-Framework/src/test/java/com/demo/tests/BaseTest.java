package com.demo.tests;

import com.demo.browser.Browser;
import com.demo.driver.WebDriverHandler;
import com.demo.utilities.ConfigProperties;
import org.testng.ITestContext;
import org.testng.ITestListener;

import java.util.Map;

public class BaseTest implements ITestListener {

    protected static String browserName;
    protected static ConfigProperties users;
    protected static Browser browser;
    protected WebDriverHandler webDriverHandler;

    public static String getBrowserName() {
        return browserName;
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart method called.");

        Map<String, String> parameters = context.getCurrentXmlTest().getAllParameters();
        browserName = parameters.get("browser");
        System.out.println("Browser set: " + browserName);
    }
}
