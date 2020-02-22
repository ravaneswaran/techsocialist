package com.techsocialist.plugin.pg.api;

public interface IRazorPayPaymentGatewayRestPlugin {

    public String processRazorPayRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception;

    public String createCustomer(String apiKey, String apiSecret, String name, String email, String contact, String failExisting) throws Exception;

    public String fetchAllCustomers(String apiKey, String apiSecret) throws Exception;

    public String fetchCustomer(String apiKey, String apiSecret, String customerId) throws Exception;
}
