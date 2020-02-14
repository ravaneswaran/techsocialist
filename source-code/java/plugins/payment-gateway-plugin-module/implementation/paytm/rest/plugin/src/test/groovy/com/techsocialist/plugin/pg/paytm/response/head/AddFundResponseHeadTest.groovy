package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class AddFundResponseHeadTest extends Specification {

    def "test AddFundResponseHead instance"(){
        when:
        AddFundResponseHead addFundResponseHead = new AddFundResponseHead()

        then:
        null != addFundResponseHead
    }
}
