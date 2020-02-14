package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class BanksEMISubventionRequestTest extends Specification{

    def "test BanksEMISubventionRequest -> productionUrlEndPointPrefix"(){

        setup:
        BanksEMISubventionRequest banksEMISubventionRequest = new BanksEMISubventionRequest()

        when:
        banksEMISubventionRequest.setVersion("v1")
        banksEMISubventionRequest.setMerchantId("1111")

        then:
        "https://securegw.paytm.in/theia/api/v1/emiSubvention/banks?mid=1111" == banksEMISubventionRequest.url(true)

    }
}
