package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class FetchInstrumentRequestTest extends Specification {

    def "test production url construction"() {
        when:
        FetchInstrumentRequest paytmRequest = new FetchInstrumentRequest()

        then:
        "https://securegw.paytm.in/paymentservices/fetch/instrument" == paytmRequest.url(true)

    }

}