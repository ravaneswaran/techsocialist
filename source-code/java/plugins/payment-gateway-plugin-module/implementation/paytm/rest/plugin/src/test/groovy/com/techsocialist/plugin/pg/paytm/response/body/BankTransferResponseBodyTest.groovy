package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class BankTransferResponseBodyTest extends Specification {

    def "test BankTransferResponseBody"(){
        when:
        BankTransferResponseBody bankTransferResponseBody = new BankTransferResponseBody()

        then:
        null != bankTransferResponseBody
    }

}
