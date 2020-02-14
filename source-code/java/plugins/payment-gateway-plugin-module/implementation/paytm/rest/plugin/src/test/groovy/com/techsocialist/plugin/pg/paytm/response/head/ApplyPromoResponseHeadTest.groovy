package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class ApplyPromoResponseHeadTest extends Specification {

    def "test ApplyPromoResponseHead instance"(){
        when:
        ApplyPromoResponseHead applyPromoResponseHead = new ApplyPromoResponseHead()

        then:
        null != applyPromoResponseHead
    }

}
