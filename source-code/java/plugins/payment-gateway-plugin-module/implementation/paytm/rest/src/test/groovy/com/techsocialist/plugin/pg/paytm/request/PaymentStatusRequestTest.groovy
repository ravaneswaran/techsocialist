package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class PaymentStatusRequestTest extends Specification{

    def "test data head"() {
        setup:
        PaymentStatusRequest paytmRequest = new PaymentStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("1111111111111111")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        PaymentStatusRequest paytmRequest = new PaymentStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        PaymentStatusRequest paytmRequest = new PaymentStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw-stage.paytm.in/merchant-status/api/v1/getPaymentStatus" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        PaymentStatusRequest paytmRequest = new PaymentStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/merchant-status/api/v1/getPaymentStatus" == paytmRequest.url(true)

    }
}
