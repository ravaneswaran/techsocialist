package com.techsocialist.webapps.selenium;

import com.techsocialist.utilities.server.SeleniumSupport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.server.SeleniumServer;

import java.net.MalformedURLException;

public class TestChromeDriver extends SeleniumSupport {

    //https://tecadmin.net/setup-selenium-chromedriver-on-ubuntu/

    @BeforeClass
    public static void startSeleniumServer() throws Exception {
        _server = new SeleniumServer();
        _server.boot();
        _server.start();
    }

    @AfterClass
    public static void stopSeleniumServer() throws Exception {
        _seleniumWebDriver.close();
        _server.stop();
    }

    @Test
    public void chromeDriverTest() throws MalformedURLException, InterruptedException {
        _seleniumWebDriver.get("https://www.youtube.com");
        _seleniumWebDriver.findElement(By.id("search")).sendKeys("i am a rider featuring iron man");
        _seleniumWebDriver.findElement(By.id("search")).sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @Test
    public void additionalTest(){
        System.out.println("-------------------->>>>>>>>");
    }

}
