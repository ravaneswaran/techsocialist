package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class DisburseStatusQueryRequestTest extends Specification {

    def "test DisburseStatusQueryRequest -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        DisburseStatusQueryRequest disburseStatusQueryRequest = new DisburseStatusQueryRequest()
        disburseStatusQueryRequest.setVersion("v1")

        then:
        null == disburseStatusQueryRequest.dataHead()

    }

    def "test DisburseStatusQueryRequest -> productionUrlEndPointPrefix"(){

        setup:
        DisburseStatusQueryRequest disburseStatusQueryRequest = new DisburseStatusQueryRequest()

        when:
        disburseStatusQueryRequest.setVersion("v1")

        then:
        "https://dashboard.paytm.com/bpay/api/v1/disburse/order/query" == disburseStatusQueryRequest.url(true)

    }
}