package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class BalanceInfoRequestTest extends Specification {

    def "test data head"() {
        setup:
        FetchBalanceInfoRequest paytmRequest = new FetchBalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setPaymentMode("submit")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        FetchBalanceInfoRequest paytmRequest = new FetchBalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setPaymentMode("submit")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        FetchBalanceInfoRequest paytmRequest = new FetchBalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setPaymentMode("submit")

        then:
        "https://securegw-stage.paytm.in/userAsset/fetchBalanceInfo?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        FetchBalanceInfoRequest paytmRequest = new FetchBalanceInfoRequest();

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setPaymentMode("submit")

        then:
        "https://securegw.paytm.in/userAsset/fetchBalanceInfo?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }
}
