package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class BankTransferResponseHeadTest extends Specification {

    def "test BankTransferResponseHeadTest instance"(){
        when:
        BankTransferResponseHead bankTransferResponseHead = new BankTransferResponseHead()

        then:
        null != bankTransferResponseHead
    }
}
