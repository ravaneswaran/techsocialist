package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class SendOTPResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null != sendOTPResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        false == sendOTPResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> sendOTPResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null != sendOTPResponse.getSendOTPResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseHead -> requestId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null == sendOTPResponse.getSendOTPResponseHead().getRequestId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null != sendOTPResponse.getSendOTPResponseHead().getResponseTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null != sendOTPResponse.getSendOTPResponseHead().getVersion()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> sendOTPResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null == sendOTPResponse.getSendOTPResponseBody().getExtraParamsMap()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> sendOTPResponseBody -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        false == sendOTPResponse.getSendOTPResponseBody().ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseBody -> extraParamsMap"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null == sendOTPResponse.getSendOTPResponseBody().getExtraParamsMap()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseBody -> resultInfo"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        null != sendOTPResponse.getSendOTPResponseBody().getResultInfo()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseBody -> ResultInfo -> resultStatus"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        "U" == sendOTPResponse.getSendOTPResponseBody().getResultInfo().getResultStatus()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseBody -> ResultInfo -> resultCode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        "00000900" == sendOTPResponse.getSendOTPResponseBody().getResultInfo().getResultCode()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.SendOTPResponse -> SendOTPResponseBody -> ResultInfo -> resultMessage"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.sendOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        SendOTPResponse sendOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, SendOTPResponse.class)

        then:
        "System error" == sendOTPResponse.getSendOTPResponseBody().getResultInfo().getResultMessage()
    }
}

