package com.techsocialist.plugin.pg.impl;

import com.techsocialist.plugin.pg.api.IRazorPayPaymentGatewayRestPlugin;

public abstract class AbstractRazorPayPaymentGatewayRestPlugin extends AbstractPaymentGatewayRestPlugin implements IRazorPayPaymentGatewayRestPlugin {

    @Override
    public String processRazorPayRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception {
        return super.processRequest(requestUrl, requestHttpMethod, requestContentType, requestData);
    }
}
