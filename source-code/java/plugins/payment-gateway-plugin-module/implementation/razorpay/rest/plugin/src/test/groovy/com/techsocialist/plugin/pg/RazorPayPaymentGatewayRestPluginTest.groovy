package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IRazorPayPaymentGatewayRestPlugin
import org.json.JSONObject

class RazorPayPaymentGatewayRestPluginTest extends AbstractRazorPaySpecification{

    def "test RazorPayPaymentGatewayRestPlugin instance"(){

        when:
        RazorPayPaymentGatewayRestPlugin razorPayPaymentGatewayRestPlugin = new RazorPayPaymentGatewayRestPlugin()

        then:
        razorPayPaymentGatewayRestPlugin instanceof IRazorPayPaymentGatewayRestPlugin
    }

    def "test RazorPayPaymentGatewayRestPlugin -> createCustomer"(){

        setup:
        RazorPayPaymentGatewayRestPlugin razorPayPaymentGatewayRestPlugin = new RazorPayPaymentGatewayRestPlugin()
        razorPayPaymentGatewayRestPlugin.setApiKey(apiKey).setApiSecret(apiSecret)
        String name = "Ravaneswaran Chinnasamy"
        String email = "test@test.com"
        String mobileNumber = "+91 9876543210"
        String failExisting = "0"

        when:
        String jsonString = razorPayPaymentGatewayRestPlugin.createCustomer(name, email, mobileNumber, failExisting)

        then:
        "{\"notes\":[],\"contact\":\"+91 9876543210\",\"name\":\"Ravaneswaran Chinnasamy\",\"created_at\":1582351323,\"id\":\"cust_EJgNdD15xjPO8g\",\"gstin\":null,\"entity\":\"customer\",\"email\":\"test@test.com\"}" == jsonString

    }

    def "test RazorPayPaymentGatewayRestPlugin -> fetchAllCustomers"(){

        setup:
        RazorPayPaymentGatewayRestPlugin razorPayPaymentGatewayRestPlugin = new RazorPayPaymentGatewayRestPlugin()
        razorPayPaymentGatewayRestPlugin.setApiKey(apiKey).setApiSecret(apiSecret)

        when:
        String jsonString = razorPayPaymentGatewayRestPlugin.fetchAllCustomers()

        then:
        "" == jsonString

    }

    def "test RazorPayPaymentGatewayRestPlugin -> fetchCustomer"(){

        setup:
        RazorPayPaymentGatewayRestPlugin razorPayPaymentGatewayRestPlugin = new RazorPayPaymentGatewayRestPlugin()
        razorPayPaymentGatewayRestPlugin.setApiKey(apiKey).setApiSecret(apiSecret)
        String name = "Ravaneswaran Chinnasamy"
        String email = "test@test.com"
        String mobileNumber = "+91 9876543210"
        String failExisting = "0"
        String jsonString = razorPayPaymentGatewayRestPlugin.createCustomer(name, email, mobileNumber, failExisting)
        JSONObject jsonObject = new JSONObject(jsonString)
        String customerId = jsonObject.get("id")

        when:
        jsonString = razorPayPaymentGatewayRestPlugin.fetchCustomer(customerId)

        then:
        "{\"notes\":[],\"contact\":\"+91 9876543210\",\"name\":\"Ravaneswaran Chinnasamy\",\"created_at\":1582351323,\"id\":\"cust_EJgNdD15xjPO8g\",\"gstin\":null,\"entity\":\"customer\",\"email\":\"test@test.com\"}" == jsonString

    }

    def "test RazorPayPaymentGatewayRestPlugin -> editCustomer"(){

        setup:
        RazorPayPaymentGatewayRestPlugin razorPayPaymentGatewayRestPlugin = new RazorPayPaymentGatewayRestPlugin()
        razorPayPaymentGatewayRestPlugin.setApiKey(apiKey).setApiSecret(apiSecret)
        String name = "Ravaneswaran Chinnasamy"
        String email = "test@test.com"
        String mobileNumber = "+91 11111111111"
        String failExisting = "0"
        String jsonString = razorPayPaymentGatewayRestPlugin.createCustomer(name, email, mobileNumber, failExisting)
        JSONObject jsonObject = new JSONObject(jsonString)
        String customerId = jsonObject.get("id")

        when:
        jsonString = razorPayPaymentGatewayRestPlugin.editCustomer(customerId, name, email, mobileNumber)

        then:
        "{\"notes\":[],\"contact\":\"+91 11111111111\",\"name\":\"Ravaneswaran Chinnasamy\",\"created_at\":1582357865,\"id\":\"cust_EJiEnaZl30KR1x\",\"gstin\":null,\"entity\":\"customer\",\"email\":\"test@test.com\"}" == jsonString

    }

    def "test RazorPayPaymentGatewayRestPlugin -> createOrder"(){

        setup:
        RazorPayPaymentGatewayRestPlugin razorPayPaymentGatewayRestPlugin = new RazorPayPaymentGatewayRestPlugin()
        razorPayPaymentGatewayRestPlugin.setApiKey(apiKey).setApiSecret(apiSecret)
        long amount = 5000
        String currency = "INR"
        long receiptId = new Date().getTime();
        String receipt = String.format("order_rcptid_%s", receiptId)
        boolean paymentCapture = true

        when:
        String jsonString = razorPayPaymentGatewayRestPlugin.createOrder(amount, currency, receipt, paymentCapture)

        then:
        null != jsonString

    }

    def "test RazorPayPaymentGatewayRestPlugin -> fetchAllOrders"(){

        setup:
        RazorPayPaymentGatewayRestPlugin razorPayPaymentGatewayRestPlugin = new RazorPayPaymentGatewayRestPlugin()
        razorPayPaymentGatewayRestPlugin.setApiKey(apiKey).setApiSecret(apiSecret)

        when:
        String jsonString = razorPayPaymentGatewayRestPlugin.fetchAllOrders()

        then:
        null != jsonString
    }

}
