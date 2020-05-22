package com.techsocialist.controlpanel.ticketconfig.integration;

import com.liferay.arquillian.containter.remote.enricher.Inject;
import com.techsocialist.controlpanel.ticketconfig.TicketConfigurationTestHelper;
import com.techsocialist.controlpanel.ticketconfig.service.api.TicketPriceService;
import com.techsocialist.servicebuilder.model.TicketPrice;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(Arquillian.class)
public class TicketPriceConfigurationTest extends TicketConfigurationTestHelper {

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

        Path jarFilePath = Paths.get("build/libs/com.techsocialist.controlpanel.ticketconfig-1.0.0.jar");
        Files.copy(jarFilePath, new FileOutputStream(
                tempDir.getAbsolutePath() +
                        "/com.techsocialist.controlpanel.ticketconfig-1.0.0.jar"));

        final File jarFile = new File(
                tempDir.getAbsolutePath() +
                        "/com.techsocialist.controlpanel.ticketconfig-1.0.0.jar");

        return ShrinkWrap.createFromZipFile(JavaArchive.class, jarFile);
    }

    @Test
    public void testAddTicketPrice(){
        long price = 50;
        String userFullName = "Ravaneswaran Chinnsamy";
        TicketPrice ticketPrice = _ticketPriceService.addTicketPrice(price, userFullName);

        Assert.assertNotNull(ticketPrice);
        Assert.assertTrue(0 != ticketPrice.getId());
    }

    @Inject
    private TicketPriceService _ticketPriceService;

}
