package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class FetchAllOffersRequestTest extends Specification{

    def "test FetchAllOffersRequest -> productionUrlEndPointPrefix"(){

        setup:
        FetchAllOffersRequest fetchAllOffersRequest = new FetchAllOffersRequest()
        fetchAllOffersRequest.setMerchantId("1111")

        when:
        fetchAllOffersRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/theia/api/v1/fetchAllPaymentOffers?mid=1111" == fetchAllOffersRequest.url(true)

    }
}
