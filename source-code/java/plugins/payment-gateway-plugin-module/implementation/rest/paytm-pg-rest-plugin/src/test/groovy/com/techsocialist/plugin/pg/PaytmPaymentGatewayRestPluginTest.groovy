package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin

class PaytmPaymentGatewayRestPluginTest extends AbstractPaytmPaymentGatewayTest{

    def "test plugin instance"(){
        when:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        then:
        null != paymentGatewayRestPlugin && paymentGatewayRestPlugin instanceof IPaymentGatewayRestPlugin
    }
}
