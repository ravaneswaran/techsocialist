package com.techsocialist.utilities.clients.okhttp;

import junit.framework.TestCase;
import okhttp3.Response;
import org.junit.Assert;

import java.io.IOException;

public class TestTechSocialistOkHttpClient extends TestCase {

    TechSocialistOkHttpClient techSocialistOkHttpClient = new TechSocialistOkHttpClient();

    public void testInstance(){
        Assert.assertNotNull(techSocialistOkHttpClient);
    }

    public void testDoGet() throws IOException {
        String url = "https://www.google.com";
        Response response = this.techSocialistOkHttpClient.doGet(url);
        Assert.assertEquals(200, response.code());
        Assert.assertNotNull(response);
    }
}
