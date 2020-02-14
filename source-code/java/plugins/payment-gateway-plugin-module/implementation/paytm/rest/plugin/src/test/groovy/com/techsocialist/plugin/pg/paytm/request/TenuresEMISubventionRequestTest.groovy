package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class TenuresEMISubventionRequestTest extends Specification{

    def "test TenuresEMISubventionRequest -> productionUrlEndPointPrefix"(){

        setup:
        TenuresEMISubventionRequest tenuresEMISubventionRequest = new TenuresEMISubventionRequest()

        when:
        tenuresEMISubventionRequest.setVersion("v1")
        tenuresEMISubventionRequest.setMerchantId("1111")

        then:
        "https://securegw.paytm.in/theia/api/v1/emiSubvention/tenures?mid=1111" == tenuresEMISubventionRequest.url(true)

    }
}
