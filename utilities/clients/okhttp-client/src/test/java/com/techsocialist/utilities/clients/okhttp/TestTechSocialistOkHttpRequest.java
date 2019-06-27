package com.techsocialist.utilities.clients.okhttp;

import junit.framework.TestCase;
import okhttp3.MediaType;
import okhttp3.Request;
import org.junit.Assert;

public class TestTechSocialistOkHttpRequest extends TestCase {

    TechSocialistOkHttpRequest techSocialistRequest = new TechSocialistOkHttpRequest("https://www.google.com");

    public void testInstance(){
        Assert.assertNotNull(techSocialistRequest);
    }

    public void testGetOkHttpRequest(){
        Request request = this.techSocialistRequest.getOkHttpRequest();
    }

    public void testAddQueryParameter(){
        String name = "name";
        String value = "Ravaneswaran";
        TechSocialistOkHttpRequest newTechSocialistRequest = this.techSocialistRequest.addQueryParameter(name, value);
        Assert.assertNotNull(newTechSocialistRequest);
    }

    public void testAddHeaders(){
        String name = "name";
        String value = "Ravaneswaran";
        TechSocialistOkHttpRequest newTechSocialistRequest = this.techSocialistRequest.addHeader(name, value);
        Assert.assertNotNull(newTechSocialistRequest);
    }

    public void testAddRequestBody(){
        String requestBody = "";
        MediaType mediaType = MediaType.parse("text/html; charset=utf-8");
        TechSocialistOkHttpRequest newTechSocialistRequest = this.techSocialistRequest.addBody_Post(mediaType, requestBody);
        Assert.assertNotNull(newTechSocialistRequest);
    }

    public void testAddJsonRequestBody(){
        String requestBody = "";
        TechSocialistOkHttpRequest newTechSocialistRequest = this.techSocialistRequest.addJsonBody(requestBody);
        Assert.assertNotNull(newTechSocialistRequest);
    }

}
