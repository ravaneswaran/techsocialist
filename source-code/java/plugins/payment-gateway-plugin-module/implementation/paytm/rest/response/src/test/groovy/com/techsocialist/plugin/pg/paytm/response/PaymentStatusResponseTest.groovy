package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.PaymentStatusResponseBody
import com.techsocialist.plugin.pg.paytm.response.head.PaymentStatusResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class PaymentStatusResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)

        then:
        null != paymentStatusResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)

        then:
        false == paymentStatusResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead.getResponseTimestamp() && paymentStatusResponseHead.getResponseTimestamp().length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead.getVersion() && "v1" == paymentStatusResponseHead.getVersion()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseHead -> signature"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead.getSignature() && paymentStatusResponseHead.getSignature().length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null != paymentStatusResponseBody
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> transactionId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> bankTransactionId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getBankTransactionId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> orderId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        orderId == paymentStatusResponseBody.getOrderId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> transactionAmount"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionAmount()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> transactionType"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionType()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> gatewayName"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getGatewayName()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> bankName"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getBankName()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> merchantId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        merchantId == paymentStatusResponseBody.getMerchantId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> paymentMode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getPaymentMode()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> refundAmount"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getRefundAmount()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.PaymentStatusResponse -> PaymentStatusResponseBody -> transactionDate"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionDate()
    }
}
