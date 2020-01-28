package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.DirectBankResponseBody
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.TransactionInfo
import com.techsocialist.plugin.pg.paytm.response.head.DirectBankResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class DirectBankResponseTest extends AbstractPaytmResponseTest{

    def "test DirectBankResponse as json string"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)

        then:
        null != jsonResponse
    }

    def "test DirectBankResponse as object"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)

        then:
        null != directBankResponse
    }

    def "test DirectBankResponse -> ok()"(){

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
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String requestType = "submit"
        String otp = "123456"

        when:
        jsonResponse = paymentGatewayRestPlugin.directBankRequest(merchantId, merchantKey, orderId, transactionToken, requestType, otp)
        DirectBankResponse directBankResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, DirectBankResponse.class)

        then:
        false == directBankResponse.ok()
    }

    def "test DirectBankResponse -> directBankResponseHead"(){

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

    def "test DirectBankResponse -> directBankResponseBody"(){

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

    def "test DirectBankResponse -> DirectBankResponseBody -> callbackUrl"(){

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

    def "test DirectBankResponse -> DirectBankResponseBody -> transactionInfo"(){

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

    def "test DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> bankName"(){

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

    def "test DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> gatewayName"(){

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

    def "test DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> transactionDate"(){

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

    def "test DirectBankResponse -> DirectBankResponseBody -> TransactionInfo -> transactionId"(){

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
