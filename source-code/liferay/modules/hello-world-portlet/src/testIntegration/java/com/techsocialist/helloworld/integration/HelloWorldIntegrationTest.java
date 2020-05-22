package com.techsocialist.helloworld.integration;

import com.liferay.arquillian.containter.remote.enricher.Inject;
import com.liferay.portal.kernel.exception.PortalException;
import com.techsocialist.helloworld.HelloWorldTestHelper;
import com.techsocialist.helloworld.service.HelloWorldService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(Arquillian.class)
public class HelloWorldIntegrationTest {

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
        final String result = _helloWorldService.greetTheWorld();

        Assert.assertEquals("Hello World", result);
    }

    @Inject
    private HelloWorldService _helloWorldService;

}
