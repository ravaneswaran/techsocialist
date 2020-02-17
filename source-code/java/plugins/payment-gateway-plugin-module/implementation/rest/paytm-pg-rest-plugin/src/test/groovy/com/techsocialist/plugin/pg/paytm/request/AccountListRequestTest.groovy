package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class AccountListRequestTest extends Specification {

    def "test AccountListRequest -> com.techsocialist.plugin.pg.paytm.response.head"() {

        when:
        AccountListRequest accountListRequest = new AccountListRequest()
        accountListRequest.setVersion("v1")

        then:
        null == accountListRequest.dataHead()

    }

    def "test AccountListRequest -> productionUrlEndPointPrefix"() {

        setup:
        AccountListRequest accountListRequest = new AccountListRequest()

        when:
        accountListRequest.setVersion("v1")

        then:
        "https://dashboard.paytm.com/bpay/api/v1/account/list" == accountListRequest.url(true)

    }
}