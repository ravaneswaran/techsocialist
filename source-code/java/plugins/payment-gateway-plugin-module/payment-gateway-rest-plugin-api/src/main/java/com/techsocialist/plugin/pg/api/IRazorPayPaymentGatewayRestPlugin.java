package com.techsocialist.plugin.pg.api;

public interface IRazorPayPaymentGatewayRestPlugin {

    public String processRazorPayRequest(String requestUrl, String requestHttpMethod, String requestContentType, String requestData) throws Exception;

    public IRazorPayPaymentGatewayRestPlugin setApiKey(String apiKey);

    public IRazorPayPaymentGatewayRestPlugin setApiSecret(String apiSecret);

    public String createCustomer(String name, String email, String mobileNumber, String failExisting) throws Exception;

    public String fetchAllCustomers() throws Exception;

    public String fetchCustomer(String customerId) throws Exception;

    public String editCustomer(String customerId, String name, String email, String mobileNumber) throws Exception;

    public String createOrder(long amount, String currency, String receipt, boolean paymentCapture) throws Exception;

    public String fetchAllOrders() throws Exception;

    public String fetchOrder(String orderId) throws Exception;

    public String fetchPaymentsForAnOrder(String orderId) throws Exception;

    public String updateOrder(String orderId) throws Exception;
}
