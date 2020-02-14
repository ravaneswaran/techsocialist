package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class MandateFormNotifyRequestTest extends Specification {

    def "test MandateFormNotifyRequest -> productionUrlEndPointPrefix"(){

        setup:
        MandateFormNotifyRequest mandateFormNotifyRequest = new MandateFormNotifyRequest()

        when:
        mandateFormNotifyRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/subscription/paper/mandate/notifyUpload" == mandateFormNotifyRequest.url(true)

    }

}
