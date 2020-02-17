package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class CancelSubscriptionReqsponseTest extends Specification{

    def "test data com.techsocialist.plugin.pg.paytm.response.head with token type AES"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("1111111111111111")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTokenType("AES").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data com.techsocialist.plugin.pg.paytm.response.head with token type SSO"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTokenType("SSO").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data com.techsocialist.plugin.pg.paytm.response.body with token type AES"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTokenType("AES").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataBody()
    }

    def "test data com.techsocialist.plugin.pg.paytm.response.body with with token type SSO"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTokenType("SSO").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        null != paytmRequest.dataBody()
    }

    def "test staging url construction"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTokenType("AES").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        "https://securegw-stage.paytm.in/subscription/cancel" == paytmRequest.url(false)

    }

    def "test production url construction"(){
        setup:
        CancelSubscriptionRequest paytmRequest = new CancelSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setTokenType("AES").setSubscriptionId("subscription-001").setSsoToken("ss0-001")

        then:
        "https://securegw.paytm.in/subscription/cancel" == paytmRequest.url(true)

    }
}
