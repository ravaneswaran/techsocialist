package com.techsocialist.plugin.pg;

import com.razorpay.Customer;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.techsocialist.plugin.pg.impl.AbstractRazorPayPaymentGatewayRestPlugin;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RazorPayPaymentGatewayRestPlugin extends AbstractRazorPayPaymentGatewayRestPlugin {

    @Override
    public String createCustomer(String name, String email, String mobileNumber, String failExisting) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("contact", mobileNumber);
        jsonObject.put("fail_existing", failExisting);

        RazorpayClient razorpayClient = new RazorpayClient(this.apiKey, this.apiSecret);
        Customer customer = razorpayClient.Customers.create(jsonObject);

        return customer.toJson().toString();
    }

    @Override
    public String fetchAllCustomers() throws Exception {
        return "";
    }

    @Override
    public String fetchCustomer(String customerId) throws Exception {
        RazorpayClient razorpayClient = new RazorpayClient(this.apiKey, this.apiSecret);
        Customer customer = razorpayClient.Customers.fetch(customerId);

        return customer.toJson().toString();
    }

    @Override
    public String editCustomer(String customerId, String name, String email, String mobileNumber) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("email", email);
        jsonObject.put("contact", mobileNumber);

        RazorpayClient razorpayClient = new RazorpayClient(this.apiKey, this.apiSecret);
        Customer customer = razorpayClient.Customers.edit(customerId, jsonObject);

        return customer.toJson().toString();
    }

    @Override
    public String createOrder(long amount, String currency, String receipt, boolean paymentCapture) throws Exception {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount", amount);
        jsonObject.put("currency", currency);
        jsonObject.put("receipt", receipt);
        jsonObject.put("payment_capture", paymentCapture);

        RazorpayClient razorpayClient = new RazorpayClient(this.apiKey, this.apiSecret);

        Order newOrder = razorpayClient.Orders.create(jsonObject);

        return newOrder.toJson().toString();
    }

    @Override
    public String fetchAllOrders() throws Exception {
        RazorpayClient razorpayClient = new RazorpayClient(this.apiKey, this.apiSecret);
        List<Order> orders = razorpayClient.Orders.fetchAll();

        List<JSONObject> items = new ArrayList<>();
        for(Order order : orders){
            items.add(order.toJson());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("entity", "collection");
        jsonObject.put("count", orders.size());
        jsonObject.put("items", items);

        return jsonObject.toString();
    }

    @Override
    public String fetchOrder(String orderId) throws Exception {
        RazorpayClient razorpayClient = new RazorpayClient(this.apiKey, this.apiSecret);
        Order order = razorpayClient.Orders.fetch(orderId);
        return order.toJson().toString();
    }

    @Override
    public String fetchPaymentsForAnOrder(String orderId) throws Exception {
        RazorpayClient razorpayClient = new RazorpayClient(this.apiKey, this.apiSecret);
        List<Payment> payments = razorpayClient.Orders.fetchPayments(orderId);

        List<JSONObject> items = new ArrayList<>();
        for(Payment payment : payments){
            items.add(payment.toJson());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("entity", "collection");
        jsonObject.put("count", payments.size());
        jsonObject.put("items", items);

        return jsonObject.toString();
    }

    @Override
    public String updateOrder(String orderId) throws Exception {
        return "";
    }
}
