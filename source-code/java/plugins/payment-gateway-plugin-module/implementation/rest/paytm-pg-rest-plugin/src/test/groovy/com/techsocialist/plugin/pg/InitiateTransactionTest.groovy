package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.InitiateTransactionResponse
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class InitiateTransactionTest extends AbstractPaytmPaymentGatewayTest{

    def "test initiate transaction"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def userId = String.format("USER-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"

        when:
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, userId, amount, currency, websiteName, callbackUrl)

        then:
        null != jsonResponse
    }

    def "test initiate transaction un marshalling"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def userId = String.format("USER-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, userId, amount, currency, websiteName, callbackUrl)
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        then:
        null != initiateTransactionResponse && null != initiateTransactionResponse.getInitiateTransactionHead() && null != initiateTransactionResponse.getInitiateTransactionBody()
    }
}
