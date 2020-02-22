package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IRazorPayPaymentGatewayRestPlugin

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
        String name = "Ravaneswaran Chinnasamy"
        String email = "test@test.com"
        String contact = "+91 9876543210"
        String failExisting = "0"

        when:
        String jsonString = razorPayPaymentGatewayRestPlugin.createCustomer(apiKey, apiSecret, name, email, contact, failExisting)

        then:
        "{\"notes\":[],\"contact\":\"+91 9876543210\",\"name\":\"Ravaneswaran Chinnasamy\",\"created_at\":1582351323,\"id\":\"cust_EJgNdD15xjPO8g\",\"gstin\":null,\"entity\":\"customer\",\"email\":\"test@test.com\"}" == jsonString

    }
}
