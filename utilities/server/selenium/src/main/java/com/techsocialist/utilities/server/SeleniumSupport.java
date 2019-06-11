package com.techsocialist.utilities.server;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.SeleniumServer;

public class SeleniumSupport {

    public static SeleniumServer _server;

    public static WebDriver _seleniumWebDriver;

    public SeleniumSupport(){
        this.setChromeDriver();
    }

    public WebDriver getChromeDriver(){
        return WithChromeSupport.getChromeDriver();
    }

    public void setChromeDriver(){
        _seleniumWebDriver = WithChromeSupport.getChromeDriver();
    }

}
