package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import spock.lang.Specification

class PaytmPaymentGatewayRestPluginTest extends Specification{

    def merchantId = "MqSnHc74327968593861"
    def merchantKey = "NgOnN7UT22rslD!%"
    def transactionToken = ""

    def "test plugin instance"(){
        when:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        then:
        null != paymentGatewayRestPlugin && paymentGatewayRestPlugin instanceof IPaymentGatewayRestPlugin

    }

    def "test initiate transaction"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def userId = String.format("%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSITE"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"

        when:
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, userId, amount, currency, websiteName, callbackUrl)

        then:
        null != jsonResponse
    }

    def "test balance info"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def paymentMode = "BALANCE"

        when:
        String jsonResponse = paymentGatewayRestPlugin.balanceInfo(merchantId, merchantKey, transactionToken, paymentMode)

        then:
        null != jsonResponse
    }
}
