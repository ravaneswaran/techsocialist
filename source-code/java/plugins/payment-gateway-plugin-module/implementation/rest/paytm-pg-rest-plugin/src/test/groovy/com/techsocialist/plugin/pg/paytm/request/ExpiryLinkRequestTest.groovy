package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class ExpiryLinkRequestTest extends Specification {

    def "test production url construction"() {
        when:
        ExpireLinkRequest paytmRequest = new ExpireLinkRequest()

        then:
        "https://securegw.paytm.in/link/expire" == paytmRequest.url(true)
    }

}
