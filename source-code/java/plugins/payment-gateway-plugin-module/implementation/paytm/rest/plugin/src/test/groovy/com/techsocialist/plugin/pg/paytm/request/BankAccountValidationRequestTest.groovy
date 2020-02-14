package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class BankAccountValidationRequestTest extends Specification{

    def "test BankAccountValidationRequest -> head"(){

        when:
        BankAccountValidationRequest bankAccountValidationRequest = new BankAccountValidationRequest()
        bankAccountValidationRequest.setVersion("v1")

        then:
        null == bankAccountValidationRequest.dataHead()

    }

    def "test BankAccountValidationRequest -> productionUrlEndPointPrefix"(){

        setup:
        BankAccountValidationRequest bankAccountValidationRequest = new BankAccountValidationRequest()

        when:
        bankAccountValidationRequest.setVersion("v1")

        then:
        "https://dashboard.paytm.com/bpay/api/v1/beneficiary/validate" == bankAccountValidationRequest.url(true)

    }
}
