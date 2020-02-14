package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class FetchLinkRequestTest extends Specification{

    def "test production url construction"() {
        when:
        FetchLinkRequest paytmRequest = new FetchLinkRequest()

        then:
        "https://securegw.paytm.in/link/fetch" == paytmRequest.url(true)
    }
}
