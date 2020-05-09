package com.techsocialist.foundation;

import com.google.common.io.Files;
import com.liferay.arquillian.containter.remote.enricher.Inject;
import com.liferay.portal.kernel.exception.PortalException;
import com.techsocialist.foundation.services.HelloWorldService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;

@RunWith(Arquillian.class)
public class HelloWorldPortletIntegrationTest {

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
                        "/techsocialist-foundation-module-1.0.0.jar");
        return ShrinkWrap.createFromZipFile(JavaArchive.class, jarFile);
    }

    @Test
    public void testAdd() throws IOException, PortalException {
        final long result = _helloWorldService.add(1, 3);

        Assert.assertEquals(4, result);
    }

    @Inject
    private HelloWorldService _helloWorldService;
}
