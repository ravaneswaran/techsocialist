package com.techsocialist.controlpanel.ticketconfig.integration;

import com.techsocialist.controlpanel.ticketconfig.TicketConfigurationTestHelper;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TicketPriceConfigurationIntegrationTest extends TicketConfigurationTestHelper {

    @Deployment
    public static JavaArchive create() throws Exception {
        final File tempDir = TicketConfigurationTestHelper.createTempDir();

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
}
