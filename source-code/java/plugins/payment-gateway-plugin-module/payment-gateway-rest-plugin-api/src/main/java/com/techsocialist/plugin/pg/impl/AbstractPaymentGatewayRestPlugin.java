package com.techsocialist.plugin.pg.impl;

import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class AbstractPaymentGatewayRestPlugin implements IPaymentGatewayRestPlugin {

    @Override
    public String processRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException {
        return this.processRequest(requestUrl, requestHttpMethod, requestContentType, null, requestData);
    }

    @Override
    public String processRequest(String requestUrl, String requestHttpMethod, String requestContentType, Map<String, String> requestProperties, String requestData) throws IOException {

        URL url = new URL(requestUrl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestHttpMethod);
        connection.setRequestProperty("Content-Type", requestContentType);

        if(null != requestProperties && requestProperties.size() > 0){
            Iterator<String> keyIterator = requestProperties.keySet().iterator();
            while(keyIterator.hasNext()){
                String key = keyIterator.next();
                String value = requestProperties.get(key);

                connection.setRequestProperty(key, value);
            }
        }

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
