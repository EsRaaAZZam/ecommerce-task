package com.demo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private final String configFilePath;
    private Properties properties;

    public ConfigProperties(String configFilePath) throws IOException {
        this.configFilePath = configFilePath;
        setConfigProperties();
    }

    private void setConfigProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(configFilePath));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getFirstName() {
        return properties.getProperty("first.name");
    }

    public String getState() {
        return properties.getProperty("state");
    }

    public String getCountry() {
        return properties.getProperty("country");
    }

    public String getPostCode() {
        return properties.getProperty("postcode");
    }

    public String getAddress() {
        return properties.getProperty("address");
    }

    public String getCity() {
        return properties.getProperty("city");
    }

    public String getEmail() {
        return properties.getProperty("valid.email");
    }

    public String getPassword() {
        return properties.getProperty("test.password");
    }
}
