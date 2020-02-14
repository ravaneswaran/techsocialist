package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class ProcessTransactionRequestTest extends Specification{

    def "test data head"() {
        setup:
        ProcessTransactionRequest paytmRequest = new ProcessTransactionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        ProcessTransactionRequest paytmRequest = new ProcessTransactionRequest()

        when:
        paytmRequest.setRequestType("requestType").setPaymentMode("paymentmode").setAuthMode("authmode")
        paytmRequest.setCardInfo("cardinfo").setPaymentFlow("paymentflow").setStoreInstrument("storeinstrument")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        ProcessTransactionRequest paytmRequest = new ProcessTransactionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw-stage.paytm.in/theia/api/v1/processTransaction?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        ProcessTransactionRequest paytmRequest = new ProcessTransactionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/theia/api/v1/processTransaction?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }
}
