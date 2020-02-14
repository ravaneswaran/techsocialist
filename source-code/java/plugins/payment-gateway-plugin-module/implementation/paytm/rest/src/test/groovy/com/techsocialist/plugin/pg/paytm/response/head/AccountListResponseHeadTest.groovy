package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class AccountListResponseHeadTest extends Specification{

    def "test AccountListResponseHeadTest instance"(){
        when:
        AccountListResponseHead accountListResponseHead = new AccountListResponseHead()

        then:
        null != accountListResponseHead
    }
}
