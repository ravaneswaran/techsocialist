package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class NetBankingPaymentChannelRequestTest extends Specification{

    def "test data com.techsocialist.plugin.pg.paytm.response.head"() {
        setup:
        FetchNBPaymentChannelRequest paytmRequest = new FetchNBPaymentChannelRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data com.techsocialist.plugin.pg.paytm.response.body"() {
        setup:
        FetchNBPaymentChannelRequest paytmRequest = new FetchNBPaymentChannelRequest()

        when:
        paytmRequest.setType("test")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        FetchNBPaymentChannelRequest paytmRequest = new FetchNBPaymentChannelRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw-stage.paytm.in/theia/api/v1/fetchNBPaymentChannels?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        FetchNBPaymentChannelRequest paytmRequest = new FetchNBPaymentChannelRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw.paytm.in/theia/api/v1/fetchNBPaymentChannels?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }
}
