package com.techsocialist.plugin.pg.paytm.request

class UpdateLinkRequestTest extends AbstractPaytmRequestTest {

    def "test production url construction"() {
        when:
        UpdateLinkRequest paytmRequest = new UpdateLinkRequest()

        then:
        "https://securegw.paytm.in/link/update" == paytmRequest.url(true)
    }

    def "test UpdateLinkRequest -> timestamp"() {
        when:
        UpdateLinkRequest paytmRequest = new UpdateLinkRequest()
        paytmRequest.setTimestamp("134567890")

        then:
        "134567890" == paytmRequest.timestamp
    }
}
