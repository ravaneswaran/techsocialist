package com.techsocialist.plugin.pg.paytm.response


import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.FetchBalanceInfoResponseBody
import com.techsocialist.plugin.pg.paytm.response.head.FetchBalanceInfoResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class FetchBalanceInfoResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.FetchBalanceInfoResponse as json string"(){
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
        jsonResponse = paymentGatewayRestPlugin.fetchBalanceInfo(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), "BALANCE")

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchBalanceInfoResponse when merchant id is wrong"(){
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
        jsonResponse = paymentGatewayRestPlugin.fetchBalanceInfo(fakeMerchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), "BALANCE")
        FetchBalanceInfoResponse fetchBalanceInfoResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBalanceInfoResponse.class)

        then:
        false == fetchBalanceInfoResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchBalanceInfoResponse when all the required/valid parameters are given"(){
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
        jsonResponse = paymentGatewayRestPlugin.fetchBalanceInfo(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), "BALANCE")
        FetchBalanceInfoResponse fetchBalanceInfoResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBalanceInfoResponse.class)

        then:
        false == fetchBalanceInfoResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchBalanceInfoResponse -> FetchBalanceInfoResponseHead"(){
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
        jsonResponse = paymentGatewayRestPlugin.fetchBalanceInfo(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), "BALANCE")
        FetchBalanceInfoResponse fetchBalanceInfoResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBalanceInfoResponse.class)
        FetchBalanceInfoResponseHead fetchBalanceInfoResponseHead = fetchBalanceInfoResponse.getFetchBalanceInfoResponseHead()

        then:
        null != fetchBalanceInfoResponseHead
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchBalanceInfoResponse -> FetchBalanceInfoResponseBody"(){
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
        jsonResponse = paymentGatewayRestPlugin.fetchBalanceInfo(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), "BALANCE")
        FetchBalanceInfoResponse fetchBalanceInfoResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBalanceInfoResponse.class)
        FetchBalanceInfoResponseBody fetchBalanceInfoResponseBody = fetchBalanceInfoResponse.getFetchBalanceInfoResponseBody()

        then:
        null != fetchBalanceInfoResponseBody
    }
}
