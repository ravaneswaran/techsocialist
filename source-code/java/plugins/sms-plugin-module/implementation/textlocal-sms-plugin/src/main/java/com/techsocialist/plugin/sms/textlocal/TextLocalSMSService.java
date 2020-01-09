package com.techsocialist.plugin.sms.textlocal;

import com.techsocialist.plugin.sms.service.api.ITextLocalSMSService;
import com.techsocialist.plugin.sms.service.impl.AbstractSMSService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TextLocalSMSService extends AbstractSMSService implements ITextLocalSMSService {

    private String apiKey;

    @Override
    public String sendSMS(String from, String to, String message) throws Exception {

        if(null == from || from.isEmpty()){
            throw new RuntimeException("from(SMS Source) cannot be null or empty...");
        }

        if(null == to || to.isEmpty()){
            throw new RuntimeException("to(SMS Destination) cannot be null or empty...");
        }

        if(null == message || message.isEmpty()){
            throw new RuntimeException("message cannot be null or empty...");
        }

        StringBuilder queryParameters = new StringBuilder();
        queryParameters.append("apikey").append("=").append(this.apiKey).append("&");
        queryParameters.append("message").append("=").append(message).append("&");
        queryParameters.append("sender").append("=").append(from).append("&");
        queryParameters.append("numbers").append("=").append(to);

        HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send?").openConnection();
        String data = queryParameters.toString();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
        conn.getOutputStream().write(data.getBytes("UTF-8"));
        final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        final StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            stringBuffer.append(line);
        }
        rd.close();

        System.out.println(stringBuffer.toString());

        return stringBuffer.toString();
    }

    @Override
    public void initialize(String apiKey) throws Exception{
        if(null == apiKey || apiKey.isEmpty()){
            throw new RuntimeException("apiKey cannot be null or empty...");
        }
        this.apiKey = apiKey;
    }
}
