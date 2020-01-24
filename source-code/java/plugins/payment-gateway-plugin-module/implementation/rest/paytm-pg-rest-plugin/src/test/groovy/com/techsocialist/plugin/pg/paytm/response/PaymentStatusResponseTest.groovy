package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.PaymentStatusResponseBody
import com.techsocialist.plugin.pg.paytm.response.head.PaymentStatusResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class PaymentStatusResponseTest extends AbstractPaytmResponseTest{

    def "test PaymentStatusResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)

        then:
        null != jsonResponse
    }

    def "test PaymentStatusResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)

        then:
        null != paymentStatusResponse
    }

    def "test PaymentStatusResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)

        then:
        false == paymentStatusResponse.ok()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead.getResponseTimestamp() && paymentStatusResponseHead.getResponseTimestamp().length() > 0
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead.getVersion() && "v1" == paymentStatusResponseHead.getVersion()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseHead -> signature"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseHead paymentStatusResponseHead = paymentStatusResponse.getPaymentStatusResponseHead()

        then:
        null != paymentStatusResponseHead.getSignature() && paymentStatusResponseHead.getSignature().length() > 0
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null != paymentStatusResponseBody
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> transactionId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionId()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> bankTransactionId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getBankTransactionId()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> orderId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        orderId == paymentStatusResponseBody.getOrderId()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> transactionAmount"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionAmount()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> transactionType"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionType()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> gatewayName"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getGatewayName()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> bankName"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getBankName()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> merchantId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        merchantId == paymentStatusResponseBody.getMerchantId()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> paymentMode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getPaymentMode()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> refundAmount"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getRefundAmount()
    }

    def "test PaymentStatusResponse -> PaymentStatusResponseBody -> transactionDate"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.paymentStatus(merchantId, merchantKey, orderId)
        PaymentStatusResponse paymentStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, PaymentStatusResponse.class)
        PaymentStatusResponseBody paymentStatusResponseBody = paymentStatusResponse.getPaymentStatusResponseBody()

        then:
        null == paymentStatusResponseBody.getTransactionDate()
    }
}
