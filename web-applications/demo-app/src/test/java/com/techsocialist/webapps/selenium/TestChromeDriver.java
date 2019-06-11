package com.techsocialist.webapps.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class TestChromeDriver extends WithSeleniumSupport {

    //https://tecadmin.net/setup-selenium-chromedriver-on-ubuntu/

    @Test
    public void testChromeDriver() throws MalformedURLException, InterruptedException {
        _chromeDriver.get("https://www.google.com");

        Thread.sleep(5000);
    }

    @Test
    public void testSimplee(){
        System.out.println("-------------------->>>>>>>>");
    }


}
