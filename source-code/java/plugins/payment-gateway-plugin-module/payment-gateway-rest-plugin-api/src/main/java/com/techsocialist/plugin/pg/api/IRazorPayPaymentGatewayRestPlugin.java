package com.techsocialist.plugin.pg.api;

public interface IRazorPayPaymentGatewayRestPlugin {

    public String processRazorPayRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception;

    public String createCustomer(String apiKey, String apiSecret, String name, String email, String mobileNumber, String failExisting) throws Exception;

    public String fetchAllCustomers(String apiKey, String apiSecret) throws Exception;

    public String fetchCustomer(String apiKey, String apiSecret, String customerId) throws Exception;

    public String editCustomer(String apiKey, String apiSecret, String customerId, String name, String email, String mobileNumber) throws Exception;
}
