package com.techsocialist.utilities.server;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

class WithChromeSupport {

    private static final String TAB  = "    ";
    private static final String CHROME_DRIVER_DOWNLOAD_LOCATION = "https://sites.google.com/a/chromium.org/chromedriver/downloads";
    private static final String CHROME_DRIVER_INSTALLATION_PATH = "/opt/bin/";
    private static final String CHROME_DRIVER_FILENAME= "chromedriver";

    private static final WebDriver WEB_DRIVER;

    public static WebDriver getChromeDriver(){
        return WEB_DRIVER;
    }

    public static void printInstallationDetails(){
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|     Installation details to install Chrome Driver      |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println();
        System.out.println("1. Download the chrome driver from the location given below....");
        System.out.println(String.format("%s-%s",TAB, CHROME_DRIVER_DOWNLOAD_LOCATION));
        System.out.println("2. Unzip the .zip file to your favourite location");
        WithChromeSupport.printInstallationDetailsInLinux();
    }

    public static void printInstallationDetailsInLinux(){
        System.out.println("3. On linux...");
        System.out.println(String.format("%s-Change the permission of chrome driver using the command 'chmod' as (sudo chmod 766 <path>/chromedriver)", TAB, CHROME_DRIVER_INSTALLATION_PATH));
        System.out.println(String.format("%s-Move the 'chromedriver' to the following location (%s)", TAB, CHROME_DRIVER_INSTALLATION_PATH));
        System.out.println(String.format("%s%s-If you do not find the location, please create one using the command 'sudo mkdir /opt/bin'", TAB, TAB));
        System.out.println();
        System.out.println("this concludes the installation of chrome driver in linux");
        System.out.println();
        System.out.println();
    }

    static {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));

        WithChromeSupport.printInstallationDetails();

        WEB_DRIVER = new ChromeDriver(chromeOptions);
        WEB_DRIVER.manage().window().maximize();
        WEB_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
