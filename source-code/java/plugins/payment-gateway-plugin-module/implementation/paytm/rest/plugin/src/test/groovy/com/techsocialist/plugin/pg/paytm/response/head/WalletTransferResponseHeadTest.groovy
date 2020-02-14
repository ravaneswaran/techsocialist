package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class WalletTransferResponseHeadTest extends Specification {

    def "test WalletTransferResponseHeadTest instance"(){
        when:
        WalletTransferResponseHead walletTransferResponseHead = new WalletTransferResponseHead()

        then:
        null != walletTransferResponseHead
    }
}
