package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.DirectBankResponseBody
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.TransactionInfo
import com.techsocialist.plugin.pg.paytm.response.head.DirectBankResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class DirectBankResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse as json string"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse as object"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)

        then:
        null != directBankResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> ok()"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)

        then:
        false == directBankResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> directBankResponseHead"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseHead directBankResponseHead = directBankResponse.getDirectBankResponseHead()

        then:
        null != directBankResponseHead
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> directBankResponseBody"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseBody directBankResponseBody = directBankResponse.getDirectBankResponseBody()

        then:
        null != directBankResponseBody
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> DirectBankResponseBody -> callbackUrl"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseBody directBankResponseBody = directBankResponse.getDirectBankResponseBody()

        then:
        null == directBankResponseBody.getCallBackUrl()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> DirectBankResponseBody -> transactionInfo"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseBody directBankResponseBody = directBankResponse.getDirectBankResponseBody()
        TransactionInfo transactionInfo = directBankResponseBody.getTransactionInfo()

        then:
        null != transactionInfo
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> bankName"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseBody directBankResponseBody = directBankResponse.getDirectBankResponseBody()
        TransactionInfo transactionInfo = directBankResponseBody.getTransactionInfo()

        then:
        null == transactionInfo.getBankName()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> gatewayName"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseBody directBankResponseBody = directBankResponse.getDirectBankResponseBody()
        TransactionInfo transactionInfo = directBankResponseBody.getTransactionInfo()

        then:
        null == transactionInfo.getGatewayName()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> transactionDate"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseBody directBankResponseBody = directBankResponse.getDirectBankResponseBody()
        TransactionInfo transactionInfo = directBankResponseBody.getTransactionInfo()

        then:
        null == transactionInfo.getTransactionDate()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> transactionId"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)
        DirectBankResponseBody directBankResponseBody = directBankResponse.getDirectBankResponseBody()
        TransactionInfo transactionInfo = directBankResponseBody.getTransactionInfo()

        then:
        null == transactionInfo.getTransactionId()
    }
}
