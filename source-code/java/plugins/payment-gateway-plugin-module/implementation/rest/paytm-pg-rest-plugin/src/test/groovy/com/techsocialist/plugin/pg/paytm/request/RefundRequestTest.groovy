package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class RefundRequestTest extends Specification{

    def "test data head"() {
        setup:
        RefundRequest paytmRequest = new RefundRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("1111111111111111")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        RefundRequest paytmRequest = new RefundRequest()

        when:
        paytmRequest.setAmountToRefund("1000.00").setRefundId("refund-id").setTransactionId("txn-id").setTransactionType("txn-type")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        RefundRequest paytmRequest = new RefundRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw-stage.paytm.in/refund/apply" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        RefundRequest paytmRequest = new RefundRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/refund/apply" == paytmRequest.url(true)

    }

}
