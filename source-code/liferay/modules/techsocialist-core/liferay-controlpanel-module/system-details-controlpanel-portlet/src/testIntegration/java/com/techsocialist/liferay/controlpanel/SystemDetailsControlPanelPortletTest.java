package com.techsocialist.liferay.controlpanel;

import com.google.common.io.Files;
import com.liferay.arquillian.portal.annotation.PortalURL;
import com.liferay.portal.kernel.exception.PortalException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.net.URL;


@RunWith(Arquillian.class)
public class SystemDetailsControlPanelPortletTest {

    @Deployment
    public static JavaArchive create() throws Exception {

        final File tempDir = Files.createTempDir();
        String gradlew = "./gradlew";

        String osName = System.getProperty("os.name", "");
        if (osName.toLowerCase().contains("windows")) {

            gradlew = "./gradlew.bat";
        }

        final ProcessBuilder processBuilder = new ProcessBuilder(
                gradlew, "jar", "-Pdir=" + tempDir.getAbsolutePath());

        final Process process = processBuilder.start();

        process.waitFor();

        final File jarFile = new File(
                tempDir.getAbsolutePath() +
                        "/system-details-controlpanel-portlet-1.0.0.jar");

        return ShrinkWrap.createFromZipFile(JavaArchive.class, jarFile);
    }

    @Test
    public void testInstallPortlet() throws IOException, PortalException {
        _browser.get(_portlerURL.toExternalForm());
        final String bodyText = _browser.getPageSource();
        Assert.assertTrue(
                "The portlet is not well deployed",
                bodyText.contains("Sample Portlet is working!"));
    }

    @Test
    public void testAdd() throws InterruptedException, IOException, PortalException {

        _browser.get(_portlerURL.toExternalForm());

        _firstParamter.clear();
        _firstParamter.sendKeys("2");

        _secondParameter.clear();
        _secondParameter.sendKeys("3");

        _add.click();

        Thread.sleep(5000);

        Assert.assertEquals("5", _result.getText());
    }

    @Drone
    private WebDriver _browser;

    @PortalURL("arquillian_sample_portlet")
    private URL _portlerURL;

    @FindBy(css = "button[type=submit]")
    private WebElement _add;

    @FindBy(css = "input[id$='firstParameter']")
    private WebElement _firstParamter;

    @FindBy(css = "span[class='result']")
    private WebElement _result;

    @FindBy(css = "input[id$='secondParameter']")
    private WebElement _secondParameter;
}
