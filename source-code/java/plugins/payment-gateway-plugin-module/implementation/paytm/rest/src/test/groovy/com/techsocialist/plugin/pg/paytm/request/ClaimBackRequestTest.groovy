package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class ClaimBackRequestTest extends Specification {

    def "test AddFundRequest -> head"(){

        when:
        ClaimBackFundRequest claimBackFundRequest = new ClaimBackFundRequest()
        claimBackFundRequest.setVersion("v1")

        then:
        null == claimBackFundRequest.dataHead()

    }

    def "test AddFundRequest -> productionUrlEndPointPrefix"(){

        setup:
        ClaimBackFundRequest claimBackFundRequest = new ClaimBackFundRequest()

        when:
        claimBackFundRequest.setVersion("v1")

        then:
        "https://dashboard.paytm.com/bpay/api/v1/account/debit" == claimBackFundRequest.url(true)

    }
}
