package com.techsocialist.utilities.clients.okhttp;

import junit.framework.TestCase;
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

}
