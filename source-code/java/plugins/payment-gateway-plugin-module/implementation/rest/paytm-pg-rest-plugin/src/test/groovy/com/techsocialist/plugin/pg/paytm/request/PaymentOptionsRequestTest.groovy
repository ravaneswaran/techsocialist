package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class PaymentOptionsRequestTest extends Specification{

    def "test data head"() {
        setup:
        PaymentOptionsRequest paytmRequest = new PaymentOptionsRequest()

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

    def "test data body"() {
        setup:
        PaymentOptionsRequest paytmRequest = new PaymentOptionsRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null == paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        PaymentOptionsRequest paytmRequest = new PaymentOptionsRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw-stage.paytm.in/theia/api/v1/fetchPaymentOptions?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        PaymentOptionsRequest paytmRequest = new PaymentOptionsRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw.paytm.in/theia/api/v1/fetchPaymentOptions?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }

}
