package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class WalletTransferResponseTest extends AbstractPaytmResponseTest {

    def "test com.techsocialist.plugin.pg.paytm.response.WalletTransferResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String orderId = String.format("OREDER-ID-%s", new Date().getTime())
        String subwalletGuid = UUID.randomUUID().toString();
        String beneficiaryEmail = "test@test.com"
        String amount = "1000"
        String beneficiaryContactNumber = "1234567890"
        boolean validateBeneficiary = false
        String beneficiaryName = "tets"
        String callbackUrl = "http://localhost:8080/test"
        String comments = "no comments"
        String solution = "food"
        String version = "v2"

        when:
        paymentGatewayRestPlugin.walletTransfer(merchantId, merchantKey, version, solution,  orderId, subwalletGuid, amount, beneficiaryEmail, beneficiaryContactNumber, validateBeneficiary, beneficiaryName, callbackUrl, comments)

        then:
        Exception exp = thrown()
        "Server returned HTTP response code: 401 for URL: https://staging-dashboard.paytm.com/bpay/api/v2/disburse/order/wallet/food" == exp.getMessage()

    }

    def "test com.techsocialist.plugin.pg.paytm.response.WalletTransferResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin()
        String orderId = String.format("OREDER-ID-%s", new Date().getTime())
        String subwalletGuid = UUID.randomUUID().toString();
        String beneficiaryEmail = "test@test.com"
        String amount = "1000"
        String beneficiaryContactNumber = "1234567890"
        boolean validateBeneficiary = false
        String beneficiaryName = "tets"
        String callbackUrl = "http://localhost:8080/test"
        String comments = "no comments"
        String solution = "food"
        String version = "v2"

        when:
        String jsonResponse = paymentGatewayRestPlugin.walletTransfer(merchantId, merchantKey, version, solution,  orderId, subwalletGuid, amount, beneficiaryEmail, beneficiaryContactNumber, validateBeneficiary, beneficiaryName, callbackUrl, comments)
        WalletTransferResponse walletTransferResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, WalletTransferResponse.class)

        then:
        thrown(Exception)
        null == walletTransferResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.WalletTransferResponse -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        WalletTransferResponse walletTransferResponse = new WalletTransferResponse()

        then:
        null == walletTransferResponse.getWalletTransferResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.WalletTransferResponse -> com.techsocialist.plugin.pg.paytm.response.body"(){

        when:
        WalletTransferResponse walletTransferResponse = new WalletTransferResponse()

        then:
        null == walletTransferResponse.getWalletTransferResponseBody()
    }
}
