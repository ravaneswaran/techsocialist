package com.techsocialist.plugin.pg;

import com.razorpay.Customer;
import com.razorpay.RazorpayClient;
import com.techsocialist.plugin.pg.impl.AbstractRazorPayPaymentGatewayRestPlugin;
import org.json.JSONObject;

public class RazorPayPaymentGatewayRestPlugin extends AbstractRazorPayPaymentGatewayRestPlugin {

    @Override
    public String createCustomer(String apiKey, String apiSecret, String name, String email, String contact, String failExisting) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("contact", contact);
        jsonObject.put("fail_existing", failExisting);

        RazorpayClient razorpayClient = new RazorpayClient(apiKey, apiSecret);
        Customer customer = razorpayClient.Customers.create(jsonObject);

        return customer.toJson().toString();
    }
}
