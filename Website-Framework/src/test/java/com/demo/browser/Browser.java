package com.demo.browser;

import com.demo.ApplicationPage;

import java.io.IOException;


public class Browser {

    public ApplicationPage applicationPage;

    public Browser() throws IOException {
        applicationPage = new ApplicationPage();
    }

}