package com.techsocialist.helloworld.functional;

import com.liferay.arquillian.portal.annotation.PortalURL;
import com.liferay.portal.kernel.exception.PortalException;
import com.techsocialist.helloworld.HelloWorldTestHelper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
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
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunAsClient
@RunWith(Arquillian.class)
public class HelloWorldFunctionalTest{

    @Deployment
    public static JavaArchive create() throws Exception {
        final File tempDir = HelloWorldTestHelper.createTempDir();

        String gradlew = "../../gradlew";

        String osName = System.getProperty("os.name", "");
        if (osName.toLowerCase().contains("windows")) {
            gradlew = "../../gradlew.bat";
        }

        final ProcessBuilder processBuilder = new ProcessBuilder(
                gradlew, "jar", "-Pdir=" + tempDir.getAbsolutePath());
        final Process process = processBuilder.start();
        process.waitFor();

        Path jarFilePath = Paths.get("build/libs/com.techsocialist.helloworld-1.0.0.jar");
        Files.copy(jarFilePath, new FileOutputStream(
                tempDir.getAbsolutePath() +
                        "/com.techsocialist.helloworld-1.0.0.jar"));

        final File jarFile = new File(
                tempDir.getAbsolutePath() +
                        "/com.techsocialist.helloworld-1.0.0.jar");

        return ShrinkWrap.createFromZipFile(JavaArchive.class, jarFile);
    }

    @Test
    public void testGreetTheWorld() throws IOException, PortalException {
        _browser.get(_portalURL.toExternalForm());
        Assert.assertEquals("Hello from HelloWorld!", _result.getText());
    }

    @FindBy(id = "01")
    private WebElement _result;

    @PortalURL("com_techsocialist_helloworld_HelloWorldPortlet")
    private URL _portalURL;

    @Drone
    private WebDriver _browser;

}
