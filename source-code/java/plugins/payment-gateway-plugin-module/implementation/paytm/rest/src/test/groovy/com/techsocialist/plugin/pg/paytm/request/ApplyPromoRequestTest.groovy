package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class ApplyPromoRequestTest extends Specification {

    def "test ApplyPromoRequest -> productionUrlEndPointPrefix"(){

        setup:
        ApplyPromoRequest applyPromoRequest = new ApplyPromoRequest()
        applyPromoRequest.setMerchantId("1111")

        when:
        applyPromoRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/theia/api/v1/applyPromo?mid=1111" == applyPromoRequest.url(true)

    }

}
