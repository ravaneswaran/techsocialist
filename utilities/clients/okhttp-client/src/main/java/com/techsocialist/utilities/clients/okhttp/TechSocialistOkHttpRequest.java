package com.techsocialist.utilities.clients.okhttp;

import okhttp3.HttpUrl;
import okhttp3.Request;

public class TechSocialistOkHttpRequest {

    private Request request;

    public TechSocialistOkHttpRequest(String url) {
        this.request = new Request.Builder()
                .url(url)
                .build();
    }

    public Request getOkHttpRequest() {
        return this.request;
    }

    public TechSocialistOkHttpRequest addQueryParameter(String name, String value) {
        HttpUrl.Builder urlBuilder = this.request.url().newBuilder();
        urlBuilder.addQueryParameter(name, value);
        String url = urlBuilder.build().toString();
        this.request = new Request.Builder()
                .url(url)
                .build();
        return this;
    }


    public TechSocialistOkHttpRequest addHeader(String name, String value) {
        Request.Builder builder = this.request.newBuilder();
        this.request = builder.header(name, value).build();
        return this;
    }
}
