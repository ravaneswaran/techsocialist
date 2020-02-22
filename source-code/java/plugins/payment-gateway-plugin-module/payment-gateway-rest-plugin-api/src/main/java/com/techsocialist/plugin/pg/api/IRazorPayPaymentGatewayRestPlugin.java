package com.techsocialist.plugin.pg.api;

public interface IRazorPayPaymentGatewayRestPlugin {

    public String processRazorPayRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception;

    public String createCustomer(String merchantId, String merchantKey, String name, String email, String contact, String failExisting) throws Exception;
}
