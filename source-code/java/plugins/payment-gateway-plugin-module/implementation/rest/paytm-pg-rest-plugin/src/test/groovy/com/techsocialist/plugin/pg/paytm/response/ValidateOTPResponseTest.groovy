package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class ValidateOTPResponseTest extends AbstractPaytmResponseTest{

    def "test ValidateOTPResponse as json string"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)

        then:
        null != jsonResponse
    }

    def "test ValidateOTPResponse as object"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null != validateOTPResponse
    }

    def "test ValidateOTPResponse -> ok()"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        false == validateOTPResponse.ok()
    }

    def "test ValidateOTPResponse -> validateOTPResponseHead"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null != validateOTPResponse.getValidateOTPResponseHead()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseHead -> requestId"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null == validateOTPResponse.getValidateOTPResponseHead().getRequestId()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseHead -> responseTimestamp"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null != validateOTPResponse.getValidateOTPResponseHead().getResponseTimestamp()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseHead -> version"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null != validateOTPResponse.getValidateOTPResponseHead().getVersion()
    }

    def "test ValidateOTPResponse -> validateOTPResponseBody"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null == validateOTPResponse.getValidateOTPResponseBody().getExtraParamsMap()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseBody -> extraParamsMap"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null == validateOTPResponse.getValidateOTPResponseBody().getExtraParamsMap()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseBody -> authenticated"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        false == validateOTPResponse.getValidateOTPResponseBody().isAuthenticated()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseBody -> resultInfo"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        null != validateOTPResponse.getValidateOTPResponseBody().getResultInfo()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseBody -> ResultInfo -> resultStatus"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        "U" == validateOTPResponse.getValidateOTPResponseBody().getResultInfo().getResultStatus()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseBody -> ResultInfo -> resultCode"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        "00000900" == validateOTPResponse.getValidateOTPResponseBody().getResultInfo().getResultCode()
    }

    def "test ValidateOTPResponse -> ValidateOTPResponseBody -> ResultInfo -> resultMessage"(){

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
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String mobileNumber = "+91 9894712345"

        when:
        jsonResponse = paymentGatewayRestPlugin.validateOTP(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, mobileNumber)
        ValidateOTPResponse validateOTPResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ValidateOTPResponse.class)

        then:
        "System error" == validateOTPResponse.getValidateOTPResponseBody().getResultInfo().getResultMessage()
    }
}
