package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class BankTransferRequestTest extends Specification {

    def "test BankTransferRequest -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        BankTransferRequest bankTransferRequest = new BankTransferRequest()
        bankTransferRequest.setVersion("v1")

        then:
        null == bankTransferRequest.dataHead()

    }

    def "test BankTransferRequest -> productionUrlEndPointPrefix"(){

        setup:
        BankTransferRequest bankTransferRequest = new BankTransferRequest()

        when:
        bankTransferRequest.setVersion("v1")

        then:
        "https://dashboard.paytm.com/bpay/api/v1/disburse/order/bank" == bankTransferRequest.url(true)

    }
}
