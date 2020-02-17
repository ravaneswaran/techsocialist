package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class RenewSubscriptionRequestTest extends Specification{

    def "test production url construction"() {
        when:
        RenewSubscriptionRequest paytmRequest = new RenewSubscriptionRequest()
        paytmRequest.setMerchantId("123")
        paytmRequest.setOrderId("456")

        then:
        "https://securegw.paytm.in/subscription/renew?mid=123&orderId=456" == paytmRequest.url(true)

    }
}
