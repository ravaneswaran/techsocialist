package com.techsocialist.foundation;

import com.google.common.io.Files;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import java.io.File;

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
}
