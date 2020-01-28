package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class DirectBankRequestTest extends Specification {

    def "test data head"() {
        setup:
        DirectBankRequest paytmRequest = new DirectBankRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setOtp("otp-001").setRequestType("requesttype-001")

        then:
        null == paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        DirectBankRequest paytmRequest = new DirectBankRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setOtp("otp-001").setRequestType("requesttype-001")

        then:
        null == paytmRequest.dataBody()
    }

    def "test data as json string"() {
        setup:
        DirectBankRequest paytmRequest = new DirectBankRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setOtp("otp-001").setRequestType("requesttype-001")

        then:
        null != paytmRequest.dataAsJsonString()
    }

    def "test staging url construction"() {
        setup:
        DirectBankRequest paytmRequest = new DirectBankRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setOtp("otp-001").setRequestType("requesttype-001")

        then:
        "https://securegw-stage.paytm.in/theia/api/v1/directBankRequest?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        DirectBankRequest paytmRequest = new DirectBankRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTransactionToken("txn-001")
        paytmRequest.setOtp("otp-001").setRequestType("requesttype-001")

        then:
        "https://securegw.paytm.in/theia/api/v1/directBankRequest?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }

}
