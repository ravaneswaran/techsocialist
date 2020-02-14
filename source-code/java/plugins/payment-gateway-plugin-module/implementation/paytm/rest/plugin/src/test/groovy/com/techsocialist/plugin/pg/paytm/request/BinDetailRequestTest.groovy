package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class BinDetailRequestTest extends Specification {

    def "test data head"() {
        setup:
        FetchBinDetailsRequest paytmRequest = new FetchBinDetailsRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        FetchBinDetailsRequest paytmRequest = new FetchBinDetailsRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setBin("bin")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        FetchBinDetailsRequest paytmRequest = new FetchBinDetailsRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw-stage.paytm.in/fetchBinDetail?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        FetchBinDetailsRequest paytmRequest = new FetchBinDetailsRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw.paytm.in/fetchBinDetail?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }
}
