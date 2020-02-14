package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class FetchTransactionRequestTest extends Specification{

    def "test production url construction"() {
        when:
        FetchTransactionRequest paytmRequest = new FetchTransactionRequest()

        then:
        "https://securegw.paytm.in/link/fetchTransaction" == paytmRequest.url(true)
    }

    def "test FetchTransactionRequest -> timestamp"() {
        when:
        FetchTransactionRequest paytmRequest = new FetchTransactionRequest()
        paytmRequest.setTimestamp("1234567890")

        then:
        "1234567890" == paytmRequest.timestamp
    }
}
