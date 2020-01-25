package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.FetchNBPaymentChannelResponseBody
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.NBPayOption
import com.techsocialist.plugin.pg.paytm.response.head.FetchNBPaymentChannelResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class FetchNBPaymentChannelResponseTest extends AbstractPaytmResponseTest {

    def "test FetchNBPaymentChannelResponse as json string"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)

        then:
        null != jsonResponse
    }

    def "test FetchNBPaymentChannelResponse as object"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)

        then:
        null != fetchNBPaymentChannelResponse
    }

    def "test FetchNBPaymentChannelResponse -> ok()"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)

        then:
        true == fetchNBPaymentChannelResponse.ok()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseHead -> requestId"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseHead fetchNBPaymentChannelResponseHead = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseHead()

        then:
        null == fetchNBPaymentChannelResponseHead.getRequestId()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseHead -> responseTimestamp"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseHead fetchNBPaymentChannelResponseHead = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseHead()

        then:
        null != fetchNBPaymentChannelResponseHead.getResponseTimestamp()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseHead -> version"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseHead fetchNBPaymentChannelResponseHead = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseHead()

        then:
        "v1" == fetchNBPaymentChannelResponseHead.getVersion()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> extraParamsMap"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()

        then:
        null == fetchNBPaymentChannelResponseBody.getExtraParamsMap()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> resultInfo"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()

        then:
        null != fetchNBPaymentChannelResponseBody.getResultInfo()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> ResultInfo -> resultCode"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()

        then:
        "0000" == fetchNBPaymentChannelResponseBody.getResultInfo().getResultCode()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> ResultInfo -> resultStatus"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()

        then:
        "S" == fetchNBPaymentChannelResponseBody.getResultInfo().getResultStatus()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> ResultInfo -> resultMsg"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()

        then:
        "Success" == fetchNBPaymentChannelResponseBody.getResultInfo().getResultMessage()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> nbPayOption"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        null != nbPayOption
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> displayName"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        "Net Banking" == nbPayOption.getDisplayName()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> feeAmount"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        null == nbPayOption.getFeeAmount()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> taxAmount"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        null == nbPayOption.getTaxAmount()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> totalTransactionAmount"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        null == nbPayOption.getTotalTransactionAmount()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> priority"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        null == nbPayOption.getPriority()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> onboarding"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        false == nbPayOption.isOnboarding()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> paymentMode"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        "NET_BANKING" == nbPayOption.getPaymentMode()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> isHybridDisabled"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        false == nbPayOption.isHybridDisabled()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> isDisabled"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        null != nbPayOption.getIsDisabled()
    }

    def "test FetchNBPaymentChannelResponse -> FetchNBPaymentChannelResponseBody -> NBayOption -> payChannelOptions"(){

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def version = "v1"
        def channelId = "WEB"
        def requestTimestamp = String.valueOf(new Date().getTime())

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)
        String transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        String type = "MERCHANT"

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchNBPaymentChannel(merchantId, merchantKey, version, channelId, requestTimestamp, orderId, transactionToken, type)
        FetchNBPaymentChannelResponse fetchNBPaymentChannelResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchNBPaymentChannelResponse.class)
        FetchNBPaymentChannelResponseBody fetchNBPaymentChannelResponseBody = fetchNBPaymentChannelResponse.getFetchNBPaymentChannelResponseBody()
        NBPayOption nbPayOption = fetchNBPaymentChannelResponseBody.getNBPayOption()

        then:
        null != nbPayOption.getPayChannelOptions() && nbPayOption.getPayChannelOptions().size() > 0
    }

}
