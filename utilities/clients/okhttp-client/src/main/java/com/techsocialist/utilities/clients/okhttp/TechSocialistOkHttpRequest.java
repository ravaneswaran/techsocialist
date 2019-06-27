package com.techsocialist.utilities.clients.okhttp;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class TechSocialistOkHttpRequest {

    public static final MediaType HTML = MediaType.parse("text/html; charset=utf-8");

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

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

    public TechSocialistOkHttpRequest addBody(MediaType mediaType, String requestBody) {
        RequestBody body = RequestBody.create(mediaType, requestBody);
        HttpUrl.Builder urlBuilder = this.request.url().newBuilder();
        String url = urlBuilder.build().toString();
        this.request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return this;
    }

    public TechSocialistOkHttpRequest addJsonBody(String requestBody) {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        return this.addBody(mediaType, requestBody);
    }
}
