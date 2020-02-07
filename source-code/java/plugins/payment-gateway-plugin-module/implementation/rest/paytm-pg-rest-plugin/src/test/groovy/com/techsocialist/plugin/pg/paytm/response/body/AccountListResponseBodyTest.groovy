package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class AccountListResponseBodyTest extends Specification{

    def "test AddFundResponseBody"(){
        when:
        AccountListResponseBody accountListResponseBody = new AccountListResponseBody()

        then:
        null != accountListResponseBody
    }
}
