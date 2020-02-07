package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class AddFundResponseHeadTest extends Specification {

    def "test BankTransferResponseHeadTest instance"(){
        when:
        AddFundResponseHead addFundResponseHead = new AddFundResponseHead()

        then:
        null != addFundResponseHead
    }
}
