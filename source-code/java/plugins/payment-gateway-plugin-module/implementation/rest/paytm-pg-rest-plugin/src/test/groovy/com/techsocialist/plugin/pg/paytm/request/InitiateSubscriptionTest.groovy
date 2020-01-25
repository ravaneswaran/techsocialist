package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class InitiateSubscriptionTest extends Specification{

    def "test data head"() {
        setup:
        InitiateSubscriptionRequest paytmRequest = new InitiateSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("1111111111111111")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")

        then:
        null != paytmRequest.dataHead()
    }

    def "test data body"() {
        setup:
        InitiateSubscriptionRequest paytmRequest = new InitiateSubscriptionRequest()

        when:
        paytmRequest.setCurrency("INR").setCustomerId("customer-001").setSubscriptionAmountType("amount-type")
        paytmRequest.setSubscriptionCallbackURL("https://localhost:8080").setSubscriptionEnableRetry("10")
        paytmRequest.setSubscriptionExpiryDate("2020-12-31")
        paytmRequest.setSubscriptionFrequency("2").setSubscriptionFrequencyUnit("freq-unit")
        paytmRequest.setSubscriptionGraceDays("10").setSubscriptionMaxAmount("1000.00").setSubscriptionPaymentMode("payment-mode")
        paytmRequest.setTransactionAmount("1000.00").setSubscriptionStartDate("2020-01-01")
        paytmRequest.setSubscriptionRetryCount("10")
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.dataBody()
    }


    def "test staging url construction"() {
        setup:
        InitiateSubscriptionRequest paytmRequest = new InitiateSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw-stage.paytm.in/subscription/create?mid=mer-001&orderId=order-001" == paytmRequest.url(false)

    }

    def "test production url construction"() {
        setup:
        InitiateSubscriptionRequest paytmRequest = new InitiateSubscriptionRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setClientId("client-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setTransactionToken("txn-001")

        then:
        "https://securegw.paytm.in/subscription/create?mid=mer-001&orderId=order-001" == paytmRequest.url(true)

    }
}
