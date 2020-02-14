package com.techsocialist.plugin.pg.paytm.response


import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.UpdateTransactionResponseBody
import com.techsocialist.plugin.pg.paytm.response.head.UpdateTransactionResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class UpdateTransactionResponseTest extends AbstractPaytmResponseTest{

    def "test UpdateTransactionResponse as json string"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.updateTransaction(merchantId, merchantKey, orderId, customerId, transactionToken, transactionAmount, currency)

        then:
        null != jsonResponse

    }

    def "test UpdateTransactionResponse as an object"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.updateTransaction(merchantId, merchantKey, orderId, customerId, transactionToken, transactionAmount, currency)
        UpdateTransactionResponse updateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateTransactionResponse.class)

        then:
        null != updateTransactionResponse

    }

    def "test UpdateTransactionResponse -> ok()"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.updateTransaction(merchantId, merchantKey, orderId, customerId, transactionToken, transactionAmount, currency)
        UpdateTransactionResponse updateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateTransactionResponse.class)

        then:
        true == updateTransactionResponse.ok()

    }

    def "test UpdateTransactionResponse -> UpdateTransactionResponseHead -> signature"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.updateTransaction(merchantId, merchantKey, orderId, customerId, transactionToken, transactionAmount, currency)
        UpdateTransactionResponse updateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateTransactionResponse.class)
        UpdateTransactionResponseHead updateTransactionResponseHead = updateTransactionResponse.getUpdateTransactionResponseHead()

        then:
        null != updateTransactionResponseHead.getSignature() && updateTransactionResponseHead.getSignature().length() > 0

    }

    def "test UpdateTransactionResponse -> UpdateTransactionResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.updateTransaction(merchantId, merchantKey, orderId, customerId, transactionToken, transactionAmount, currency)
        UpdateTransactionResponse updateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateTransactionResponse.class)
        UpdateTransactionResponseBody updateTransactionResponseBody = updateTransactionResponse.getUpdateTransactionResponseBody()

        then:
        true == updateTransactionResponseBody.ok()

    }

}
