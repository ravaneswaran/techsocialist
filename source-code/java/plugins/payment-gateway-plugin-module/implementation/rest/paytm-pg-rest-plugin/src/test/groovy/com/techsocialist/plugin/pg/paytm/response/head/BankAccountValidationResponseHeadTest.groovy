package com.techsocialist.plugin.pg.paytm.response.head


import spock.lang.Specification

class BankAccountValidationResponseHeadTest extends Specification {

    def "test BankAccountValidationResponseHead instance"(){
        when:
        BankAccountValidationResponseHead bankAccountValidationResponseHead = new BankAccountValidationResponseHead()

        then:
        null != bankAccountValidationResponseHead
    }

}
