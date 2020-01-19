package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import spock.lang.Ignore

class PaytmPaymentGatewayRestPluginTest extends AbstractPaytmPaymentGatewayTest{

    def "test plugin instance"(){
        when:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        then:
        null != paymentGatewayRestPlugin && paymentGatewayRestPlugin instanceof IPaymentGatewayRestPlugin
    }

   @Ignore
    def "test balance info"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def paymentMode = "BALANCE"

        when:
        String jsonResponse = paymentGatewayRestPlugin.balanceInfo(merchantId, merchantKey, "", paymentMode)

        then:
        null != jsonResponse
    }
}
