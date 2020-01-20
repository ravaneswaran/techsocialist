package com.techsocialist.plugin.pg.impl;

import com.techsocialist.plugin.pg.api.IPaytmPaymentGatewayRestPlugin;

import java.io.IOException;

public abstract class AbstractPaytmPaymentGatewayRestPlugin extends AbstractPaymentGatewayRestPlugin implements IPaytmPaymentGatewayRestPlugin {

    @Override
    public String processPaytmRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws IOException {
        System.out.println("requestUrl ---->>>> "+requestUrl);
        return super.processRequest(requestUrl, requestHttpMethod, requestContentType, requestData);
    }


}
