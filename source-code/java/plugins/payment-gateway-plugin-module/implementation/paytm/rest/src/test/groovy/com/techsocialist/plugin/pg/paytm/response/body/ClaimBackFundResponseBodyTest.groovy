package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class ClaimBackFundResponseBodyTest extends Specification{

    def "test AddFundResponseBody"(){
        when:
        ClaimBackFundResponseBody claimBackFundResponseBody = new ClaimBackFundResponseBody()

        then:
        null != claimBackFundResponseBody
    }
}
