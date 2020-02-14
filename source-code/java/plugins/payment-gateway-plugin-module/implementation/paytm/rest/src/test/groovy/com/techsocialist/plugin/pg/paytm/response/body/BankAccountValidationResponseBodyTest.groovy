package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class BankAccountValidationResponseBodyTest extends Specification {

    def "test BankAccountValidationResponseBody"(){
        when:
        BankAccountValidationResponseBody bankAccountValidationResponseBody = new BankAccountValidationResponseBody()

        then:
        null != bankAccountValidationResponseBody
    }
}
