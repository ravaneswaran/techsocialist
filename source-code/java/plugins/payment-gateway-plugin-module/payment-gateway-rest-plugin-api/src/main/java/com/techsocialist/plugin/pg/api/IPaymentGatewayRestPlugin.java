package com.techsocialist.plugin.pg.api;

import java.io.IOException;
import java.util.Map;

public interface IPaymentGatewayRestPlugin {

    public String processRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException;

    public String processRequest(String requestUrl, String requestHttpMethod, String requestContentType, Map<String, String> requestProperties, String requestData) throws IOException;

}
