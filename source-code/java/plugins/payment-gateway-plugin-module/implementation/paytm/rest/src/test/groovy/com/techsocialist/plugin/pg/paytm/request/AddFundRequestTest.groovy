package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class AddFundRequestTest extends Specification {

    def "test AddFundRequest -> head"(){

        when:
        AddFundRequest addFundRequest = new AddFundRequest()
        addFundRequest.setVersion("v1")

        then:
        null == addFundRequest.dataHead()

    }

    def "test AddFundRequest -> productionUrlEndPointPrefix"(){

        setup:
        AddFundRequest addFundRequest = new AddFundRequest()

        when:
        addFundRequest.setVersion("v1")

        then:
        "https://dashboard.paytm.com/bpay/api/v1/account/credit" == addFundRequest.url(true)

    }
}
