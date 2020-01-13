package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class UpdateTransactionDetailRequestTest extends Specification{

    def "test data head"() {
        setup:
        UpdateTransactionDetailRequest paytmRequest = new UpdateTransactionDetailRequest()

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
        UpdateTransactionDetailRequest paytmRequest = new UpdateTransactionDetailRequest()

        when:
        paytmRequest.setAmount("1000.00").setCurrency("INR").setCustomerId("customerId")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        UpdateTransactionDetailRequest paytmRequest = new UpdateTransactionDetailRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw-stage.paytm.in/theia/api/v1/updateTransactionDetail?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        UpdateTransactionDetailRequest paytmRequest = new UpdateTransactionDetailRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/theia/api/v1/updateTransactionDetail?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }

}
