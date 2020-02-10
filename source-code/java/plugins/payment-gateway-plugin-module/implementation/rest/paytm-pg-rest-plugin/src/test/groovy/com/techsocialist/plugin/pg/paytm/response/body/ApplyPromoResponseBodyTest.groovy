package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class ApplyPromoResponseBodyTest extends Specification {

    def "test ApplyPromoResponseBody instance"(){
        when:
        ApplyPromoResponseBody applyPromoResponseBody = new ApplyPromoResponseBody()

        then:
        null != applyPromoResponseBody
    }

}
