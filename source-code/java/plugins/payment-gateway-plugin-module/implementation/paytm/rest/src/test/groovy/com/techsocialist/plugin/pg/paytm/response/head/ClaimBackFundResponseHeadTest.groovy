package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class ClaimBackFundResponseHeadTest extends Specification{

    def "test ClaimBackFundResponseHead instance"(){
        when:
        ClaimBackFundResponseHead claimBackFundResponseHead = new ClaimBackFundResponseHead()

        then:
        null != claimBackFundResponseHead
    }
}
