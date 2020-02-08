package com.techsocialist.plugin.pg.paytm.request

class FetchSubscriptionStatusRequestTest extends AbstractPaytmRequestTest{

    def "test FetchSubscriptionStatusRequest -> productionUrlEndPointPrefix"(){

        setup:
        FetchSubscriptionStatusRequest fetchSubscriptionStatusRequest = new FetchSubscriptionStatusRequest()

        when:
        fetchSubscriptionStatusRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/subscription/checkStatus" == fetchSubscriptionStatusRequest.url(true)

    }

}
