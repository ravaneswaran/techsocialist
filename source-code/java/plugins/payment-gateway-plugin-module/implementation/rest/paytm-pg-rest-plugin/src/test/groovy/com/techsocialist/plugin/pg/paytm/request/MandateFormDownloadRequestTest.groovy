package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class MandateFormDownloadRequestTest extends Specification {

    def "test MandateFormDownloadRequest -> productionUrlEndPointPrefix"(){

        setup:
        MandateFormDownloadRequest mandateFormDownloadRequest = new MandateFormDownloadRequest()

        when:
        mandateFormDownloadRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/subscription/paper/mandate/downloadUrl" == mandateFormDownloadRequest.url(true)

    }

}
