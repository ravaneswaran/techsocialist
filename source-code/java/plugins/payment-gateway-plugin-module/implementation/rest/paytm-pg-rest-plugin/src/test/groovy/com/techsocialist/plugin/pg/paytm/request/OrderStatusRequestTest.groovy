package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class OrderStatusRequestTest extends Specification{

    def "test data head"() {
        setup:
        OrderStatusRequest paytmRequest = new OrderStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null == paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        OrderStatusRequest paytmRequest = new OrderStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null == paytmRequest.dataBody()
    }

    def "test data"() {
        setup:
        OrderStatusRequest paytmRequest = new OrderStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null != paytmRequest.data()
    }


    def "test staging url construction"() {
        setup:
        OrderStatusRequest paytmRequest = new OrderStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw-stage.paytm.in/order/status" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        OrderStatusRequest paytmRequest = new OrderStatusRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/order/status" == paytmRequest.url(true)

    }
}
