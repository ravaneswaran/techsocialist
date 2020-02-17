package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class ResendNotificationLinkRequestTest extends Specification {

    def "test production url construction"() {
        when:
        ResendNotificationLinkRequest paytmRequest = new ResendNotificationLinkRequest()

        then:
        "https://securegw.paytm.in/link/resendNotification" == paytmRequest.url(true)
    }

}
