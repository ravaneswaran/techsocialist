package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class RefundStatusRequestTest extends Specification{

    def "test data head"() {
        setup:
        RefundStatusRequest paytmRequest = new RefundStatusRequest()

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
        RefundStatusRequest paytmRequest = new RefundStatusRequest()

        when:
        paytmRequest.setRefundId("refund-id")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        RefundStatusRequest paytmRequest = new RefundStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v2")

        then:
        "https://securegw-stage.paytm.in/v2/refund/status" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        RefundStatusRequest paytmRequest = new RefundStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v2")

        then:
        "https://securegw.paytm.in/v2/refund/status" == paytmRequest.url(true)

    }

}
