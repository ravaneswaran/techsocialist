package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class FetchEMIDetailResponseTest extends AbstractPaytmResponseTest{

    def "test FetchEMIDetailResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))

        then:
        null != jsonResponse
    }

    def "test FetchEMIDetailResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        null != fetchEMIDetailResponse
    }

    def "test FetchEMIDetailResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        false == fetchEMIDetailResponse.ok()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponse"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        null != fetchEMIDetailResponse.getFetchEMIDetailResponseHead()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseHead -> requestId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        null == fetchEMIDetailResponse.getFetchEMIDetailResponseHead().getRequestId()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        null != fetchEMIDetailResponse.getFetchEMIDetailResponseHead().getResponseTimestamp()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        null != fetchEMIDetailResponse.getFetchEMIDetailResponseHead().getVersion()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseBody -> extraParamsMap"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        null == fetchEMIDetailResponse.getFetchEMIDetailResponseBody().getExtraParamsMap()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseBody -> resultInfo"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        null != fetchEMIDetailResponse.getFetchEMIDetailResponseBody().getResultInfo()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseBody -> ResultInfo -> resultStatus"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        "U" == fetchEMIDetailResponse.getFetchEMIDetailResponseBody().getResultInfo().getResultStatus()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseBody -> ResultInfo -> resultCode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        "00000900" == fetchEMIDetailResponse.getFetchEMIDetailResponseBody().getResultInfo().getResultCode()
    }

    def "test FetchEMIDetailResponse -> FetchEMIDetailResponseBody -> ResultInfo -> resultMessage"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String[] channelCodes = "12345 67890".split()
        def version = "v1"
        def channelId = "CHANNEL_ID"
        def requestTimestamp = String.valueOf(new Date().getTime())
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchEMIDetail(merchantId, merchantKey, version, channelId, requestTimestamp, transactionToken, channelCodes, String.valueOf(amount))
        FetchEMIDetailResponse fetchEMIDetailResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchEMIDetailResponse.class)

        then:
        "System error" == fetchEMIDetailResponse.getFetchEMIDetailResponseBody().getResultInfo().getResultMessage()
    }

}
