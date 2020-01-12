package com.techsocialist.plugin.pg.paytm.request

import org.json.JSONObject
import spock.lang.Specification

class AbstractPaytmRequestTest extends Specification{

    def "test data"(){
        setup:
        AbstractPaytmRequest paytmRequest = new BalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB").setPaymentMode("submit");
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.data()
    }

    def "test data when dataHead and dataBody returns null"(){
        setup:
        AbstractPaytmRequest paytmRequest = new BalanceInfoRequest(){
            @Override
            JSONObject dataHead() {
                return null
            }

            @Override
            JSONObject dataBody() {
                return null
            }
        }

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB").setPaymentMode("submit");
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.data()
    }

    def "test data as json string"(){
        setup:
        AbstractPaytmRequest paytmRequest = new BalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001").setVersion("v1").setChannelId("WEB").setPaymentMode("submit");
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.dataAsJsonString() && paytmRequest.dataAsJsonString().length() > 1
    }

}
