package com.techsocialist.webapps.selenium;

import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.server.SeleniumServer;

import java.util.Arrays;
import java.util.Properties;

public class WithSeleniumSupport extends TestCase {

    public static SeleniumServer _server = null;

    public static WebDriver _chromeDriver;

    public WithSeleniumSupport(){
        _chromeDriver = new WithChromeSupport().getChromeDriver();
    }

    @BeforeClass
    public static void startSeleniumServer() throws Exception {
        _server = new SeleniumServer();
        _server.boot();
        _server.start();
    }

    @AfterClass
    public static void stopSeleniumServer() throws Exception {
        _chromeDriver.close();
        _server.stop();
    }

    public WebDriver getChromeDriver(){
        return _chromeDriver;
    }


    private class WithChromeSupport {

        private static final String TAB  = "    ";
        private static final String CHROME_DRIVER_DOWNLOAD_LOCATION = "https://sites.google.com/a/chromium.org/chromedriver/downloads";
        private static final String CHROME_DRIVER_INSTALLATION_PATH = "/opt/bin/";
        private static final String CHROME_DRIVER_FILENAME= "chromedriver";

        private WebDriver webDriver;

        public WithChromeSupport(){
            printInstallationDetails();

            Properties properties = System.getProperties();
            properties.setProperty("webdriver.chrome.driver", CHROME_DRIVER_INSTALLATION_PATH + CHROME_DRIVER_FILENAME);

            this.webDriver = new ChromeDriver(this.getDefaultChromeOptions());
        }

        public ChromeOptions getDefaultChromeOptions(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

            return chromeOptions;
        }

        public WebDriver getChromeDriver(){
            return this.webDriver;
        }

        public void printInstallationDetails(){
            System.out.println("+--------------------------------------------------------+");
            System.out.println("|     Installation details to install Chrome Driver      |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println();
            System.out.println("1. Download the chrome driver from the location given below....");
            System.out.println(String.format("%s-%s",TAB, CHROME_DRIVER_DOWNLOAD_LOCATION));
            System.out.println("2. Unzip the .zip file to your favourite location");
            this.printInstallationDetailsInLinux();
        }

        public void printInstallationDetailsInLinux(){
            System.out.println("3. On linux...");
            System.out.println(String.format("%s-Change the permission of chrome driver using the command 'chmod' as (sudo chmod 766 <path>/chromedriver)", TAB, CHROME_DRIVER_INSTALLATION_PATH));
            System.out.println(String.format("%s-Move the 'chromedriver' to the following location (%s)", TAB, CHROME_DRIVER_INSTALLATION_PATH));
            System.out.println(String.format("%s%s-If you do not find the location, please create one using the command 'sudo mkdir /opt/bin'", TAB, TAB));
            System.out.println();
            System.out.println("this concludes the installation of chrome driver in linux");
            System.out.println();
            System.out.println();
        }
    }
}
