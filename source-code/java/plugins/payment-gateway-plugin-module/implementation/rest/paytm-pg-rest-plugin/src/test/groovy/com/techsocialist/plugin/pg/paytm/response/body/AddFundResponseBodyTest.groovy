package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class AddFundResponseBodyTest extends Specification {

    def "test AddFundResponseBody"(){
        when:
        AddFundResponseBody addFundResponseBody = new AddFundResponseBody()

        then:
        null != addFundResponseBody
    }

}
