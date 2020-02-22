package com.techsocialist.plugin.pg;

import com.razorpay.Customer;
import com.razorpay.RazorpayClient;
import com.techsocialist.plugin.pg.impl.AbstractRazorPayPaymentGatewayRestPlugin;
import org.json.JSONObject;

public class RazorPayPaymentGatewayRestPlugin extends AbstractRazorPayPaymentGatewayRestPlugin {

    @Override
    public String createCustomer(String apiKey, String apiSecret, String name, String email, String mobileNumber, String failExisting) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("contact", mobileNumber);
        jsonObject.put("fail_existing", failExisting);

        RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
        Customer customer = razorpayClient.Customers.create(jsonObject);

        return customer.toJson().toString();
    }

    @Override
    public String fetchAllCustomers(String apiKey, String apiSecret) throws Exception {
        return "";
    }

    @Override
    public String fetchCustomer(String apiKey, String apiSecret, String customerId) throws Exception {
        RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
        Customer customer = razorpayClient.Customers.fetch(customerId);

        return customer.toJson().toString();
    }

    @Override
    public String editCustomer(String apiKey, String apiSecret, String customerId, String name, String email, String mobileNumber) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("contact", mobileNumber);

        RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
        Customer customer = razorpayClient.Customers.edit(customerId, jsonObject);

        return customer.toJson().toString();
    }
}
