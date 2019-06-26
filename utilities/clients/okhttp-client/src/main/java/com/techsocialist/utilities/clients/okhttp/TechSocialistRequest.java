package com.techsocialist.utilities.clients.okhttp;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class TechSocialistRequest {

    private Request request;

    public TechSocialistRequest(String url) {
        this.request = new Request.Builder()
                .url(url)
                .build();
    }

    public Request getOkHttpRequest() {
        return this.request;
    }

    public TechSocialistRequest addQueryParameter(String name, String value) {
        HttpUrl.Builder urlBuilder = this.request.url().newBuilder();
        urlBuilder.addQueryParameter(name, value);
        String url = urlBuilder.build().toString();

        this.request = new Request.Builder()
                .url(url)
                .build();

        return this;
    }


    public TechSocialistRequest addHeader(String name, String value) {
        Request.Builder builder = this.request.newBuilder();
        this.request = builder.header(name, value).build();
        return this;
    }
}
