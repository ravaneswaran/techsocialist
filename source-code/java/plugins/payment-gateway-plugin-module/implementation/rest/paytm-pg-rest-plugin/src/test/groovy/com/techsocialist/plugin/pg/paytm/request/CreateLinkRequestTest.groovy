package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class CreateLinkRequestTest extends Specification {

    def "test production url construction"() {
        when:
        CreateLinkRequest paytmRequest = new CreateLinkRequest()

        then:
        "https://securegw.paytm.in/link/create" == paytmRequest.url(true)

    }

}
