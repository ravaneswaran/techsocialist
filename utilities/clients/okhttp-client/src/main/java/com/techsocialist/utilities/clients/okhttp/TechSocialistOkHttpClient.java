package com.techsocialist.utilities.clients.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TechSocialistOkHttpClient {

    OkHttpClient client = new OkHttpClient();

    public Response doGet(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        return this.client.newCall(request).execute();
    }
}
