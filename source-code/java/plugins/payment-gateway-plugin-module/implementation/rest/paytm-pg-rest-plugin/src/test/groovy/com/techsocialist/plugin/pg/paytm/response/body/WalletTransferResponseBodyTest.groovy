package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class WalletTransferResponseBodyTest extends Specification{

    def "test WalletTransferResponseBody"(){
        when:
        WalletTransferResponseBody walletTransferResponseBody = new WalletTransferResponseBody()

        then:
        null != walletTransferResponseBody
    }

}