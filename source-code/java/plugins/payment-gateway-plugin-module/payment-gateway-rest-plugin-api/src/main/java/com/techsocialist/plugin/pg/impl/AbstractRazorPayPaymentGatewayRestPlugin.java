package com.techsocialist.plugin.pg.impl;

import com.techsocialist.plugin.pg.api.IRazorPayPaymentGatewayRestPlugin;

public abstract class AbstractRazorPayPaymentGatewayRestPlugin extends AbstractPaymentGatewayRestPlugin implements IRazorPayPaymentGatewayRestPlugin {

    protected String apiKey;

    protected String apiSecret;

    @Override
    public String processRazorPayRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception {
        return super.processRequest(requestUrl, requestHttpMethod, requestContentType, requestData);
    }

    public IRazorPayPaymentGatewayRestPlugin setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public IRazorPayPaymentGatewayRestPlugin setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }


}
