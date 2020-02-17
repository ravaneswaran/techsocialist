package com.techsocialist.plugin.pg.paytm.request

import spock.lang.Specification

class WalletTransferRequestTest extends Specification {

    def "test WalletTransferRequest -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        WalletTransferRequest walletTransferRequest = new WalletTransferRequest()
        walletTransferRequest.setVersion("v1")
        walletTransferRequest.setSolution("food")

        then:
        null == walletTransferRequest.dataHead()

    }

    def "test WalletTransferRequest -> productionUrlEndPointPrefix"(){

        setup:
        WalletTransferRequest walletTransferRequest = new WalletTransferRequest()

        when:
        walletTransferRequest.setVersion("v1")
        walletTransferRequest.setSolution("food")

        then:
        "https://dashboard.paytm.com/bpay/api/v1/disburse/order/wallet/food" == walletTransferRequest.url(true)

    }
}
