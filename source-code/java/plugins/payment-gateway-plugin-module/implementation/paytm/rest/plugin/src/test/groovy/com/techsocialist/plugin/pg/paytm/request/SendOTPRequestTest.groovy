package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class SendOTPRequestTest extends Specification{

    def "test data com.techsocialist.plugin.pg.paytm.response.head"() {
        setup:
        SendOTPRequest paytmRequest = new SendOTPRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data com.techsocialist.plugin.pg.paytm.response.body"() {
        setup:
        SendOTPRequest paytmRequest = new SendOTPRequest()

        when:
        paytmRequest.setMobileNumber("mobile-number")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        SendOTPRequest paytmRequest = new SendOTPRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v2")

        then:
        "https://securegw-stage.paytm.in/login/sendOtp?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        SendOTPRequest paytmRequest = new SendOTPRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v2")

        then:
        "https://securegw.paytm.in/login/sendOtp?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }

}
