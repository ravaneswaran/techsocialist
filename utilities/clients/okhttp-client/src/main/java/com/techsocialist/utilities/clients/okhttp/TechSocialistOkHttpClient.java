package com.techsocialist.utilities.clients.okhttp;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TechSocialistOkHttpClient {

    private Map<String, String> headers = new HashMap<String, String>();

    OkHttpClient client = new OkHttpClient();

    public void addRequestHeader(String name, String value) {
        this.headers.put(name, value);
    }

    private void addRequestHeaders(TechSocialistOkHttpRequest techSocialistOkHttpRequest) {
        Iterator<String> iterator = this.headers.keySet().iterator();
        while (iterator.hasNext()) {
            String headerKey = iterator.next();
            String headerValue = this.headers.get(headerKey);

            techSocialistOkHttpRequest.addHeader(headerKey, headerValue);
        }
    }

    public Response doGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        return this.client.newCall(request).execute();
    }

    public Response doPost(String url, MediaType mediaType, String requestBody) throws IOException {
        TechSocialistOkHttpRequest techSocialistOkHttpRequest = new TechSocialistOkHttpRequest(url);
        techSocialistOkHttpRequest = techSocialistOkHttpRequest.addBody_Post(mediaType, requestBody);
        this.addRequestHeaders(techSocialistOkHttpRequest);

        return this.client.newCall(techSocialistOkHttpRequest.getOkHttpRequest()).execute();
    }

    public Response doPut(String url, MediaType mediaType, String requestBody) throws IOException {
        TechSocialistOkHttpRequest techSocialistOkHttpRequest = new TechSocialistOkHttpRequest(url);
        techSocialistOkHttpRequest = techSocialistOkHttpRequest.addBody_Put(mediaType, requestBody);
        this.addRequestHeaders(techSocialistOkHttpRequest);

        return this.client.newCall(techSocialistOkHttpRequest.getOkHttpRequest()).execute();
    }


}
