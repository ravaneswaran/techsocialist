package com.techsocialist.plugin.pg.impl;

import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class AbstractPaymentGatewayRestPlugin implements IPaymentGatewayRestPlugin {

    @Override
    public String processRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException {

        URL url = new URL(requestUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestHttpMethod);
        connection.setRequestProperty("Content-Type", requestContentType);
        connection.setDoOutput(true);

        DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());

        requestWriter.writeBytes(requestData);
        requestWriter.close();

        InputStream is = connection.getInputStream();
        BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));

        String responseData = responseReader.readLine();

        responseReader.close();

        return responseData;
    }
}
