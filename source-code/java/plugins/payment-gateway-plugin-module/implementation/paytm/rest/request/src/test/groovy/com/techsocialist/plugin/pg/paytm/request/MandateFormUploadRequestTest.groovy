package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class MandateFormUploadRequestTest extends Specification {

    def "test MandateFormUploadRequest -> productionUrlEndPointPrefix"(){

        setup:
        MandateFormUploadRequest mandateFormUploadRequest = new MandateFormUploadRequest()

        when:
        mandateFormUploadRequest.setVersion("v1")

        then:
        "https://securegw.paytm.in/subscription/paper/mandate/uploadUrl" == mandateFormUploadRequest.url(true)

    }

}
