package com.techsocialist.utilities.clients.okhttp;

import junit.framework.TestCase;
import okhttp3.MediaType;
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

    public void testDoPost() throws IOException {
        String url = "https://tuttofood.mm.h2h.net/fiera-REST-full-web-services-portlet/api/mm/agenda/listAppointments";
        String requestBody = "{\n" +
                "   \"id_manif\": \"368\",\n" +
                "   \"id_ediz\": \"20\",\n" +
                "   \"mail\": \"buyer.smartdistrict@gmail.com\",\n" +
                "   \"language\": \"IT\",\n" +
                "   \"external_id\": \"\",\n" +
                "   \"cod_20\": \"\"\n" +
                "}";
        this.techSocialistOkHttpClient.addRequestHeader("auth-token", "d11fa866-943d-4615-bcae-41a800dab7c2");
        this.techSocialistOkHttpClient.addRequestHeader("service-key", "c60ebc67-df5c-4b30-9378-4359568rf5b2");
        MediaType mediaType = TechSocialistOkHttpRequest.JSON;

        Response response = this.techSocialistOkHttpClient.doPost(url, mediaType, requestBody);

        System.out.println("POST : " + response.body().string());

        Assert.assertEquals(200, response.code());
        Assert.assertNotNull(response);
    }

    public void testDoPut() throws IOException {
        String url = "https://tuttofood.mm.h2h.net/fiera-REST-full-web-services-portlet/api/mm/agenda/listAppointments";
        String requestBody = "{\n" +
                "   \"id_manif\": \"368\",\n" +
                "   \"id_ediz\": \"20\",\n" +
                "   \"mail\": \"buyer.smartdistrict@gmail.com\",\n" +
                "   \"language\": \"IT\",\n" +
                "   \"external_id\": \"\",\n" +
                "   \"cod_20\": \"\"\n" +
                "}";
        this.techSocialistOkHttpClient.addRequestHeader("auth-token", "d11fa866-943d-4615-bcae-41a800dab7c2");
        this.techSocialistOkHttpClient.addRequestHeader("service-key", "c60ebc67-df5c-4b30-9378-4359568rf5b2");
        MediaType mediaType = TechSocialistOkHttpRequest.JSON;

        Response response = this.techSocialistOkHttpClient.doPut(url, mediaType, requestBody);

        System.out.println("PUT : "+response.body().string());

        Assert.assertEquals(200, response.code());
        Assert.assertNotNull(response);
    }

}
