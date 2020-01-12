package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class CancelSubscriptionRequestTest extends Specification{

    def "test data head with token type AES"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1").setTokenType("AES").setSignature("signature").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data head with token type SSO"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1").setTokenType("SSO").setSignature("signature").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data body with token type AES"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1").setTokenType("AES").setSignature("signature").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataBody()
    }

    def "test data body with with token type SSO"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1").setTokenType("SSO").setSignature("signature").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataBody()
    }

    def "test staging url construction"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1").setTokenType("AES").setSignature("signature").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        "https://securegw-stage.paytm.in/subscription/cancel" == paytmRequest.url(false)

    }

    def "test production url construction"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1").setTokenType("AES").setSignature("signature").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        "https://securegw.paytm.in/subscription/cancel" == paytmRequest.url(true)

    }
}
