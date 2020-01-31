package com.techsocialist.plugin.pg.impl;

import com.techsocialist.plugin.pg.api.IPaytmPaymentGatewayRestPlugin;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractPaytmPaymentGatewayRestPlugin extends AbstractPaymentGatewayRestPlugin implements IPaytmPaymentGatewayRestPlugin {

    @Override
    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException {
        return super.processRequest(requestUrl, requestHttpMethod, requestContentType,null, requestData);
    }

    @Override
    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, Map<String, String> requestProperties, String requestData) throws IOException {
        return super.processRequest(requestUrl, requestHttpMethod, requestContentType, requestProperties, requestData);
    }

}
