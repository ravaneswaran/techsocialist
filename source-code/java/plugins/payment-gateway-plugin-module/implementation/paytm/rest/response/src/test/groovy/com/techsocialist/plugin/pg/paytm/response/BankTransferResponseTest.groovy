package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class BankTransferResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.BankTransferResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String orderId = String.format("OREDER-ID-%s", new Date().getTime())
        String subwalletGuid = UUID.randomUUID().toString();
        String beneficiaryAccount = "1234567890"
        String amount = "1000"
        String beneficiaryIFSC = "ICICI001"
        String purpose = ""
        String date = "2020-02-07"
        String callbackUrl = "http://localhost:8080/test"
        String comments = "no comments"
        String transferMode = "NEFT"
        String version = "v1"

        when:
        paymentGatewayRestPlugin.bankTransfer(merchantId, merchantKey, version, orderId, subwalletGuid, amount, beneficiaryAccount, beneficiaryIFSC, purpose, date, transferMode, callbackUrl, comments)

        then:
        Exception exp = thrown()
        "Server returned HTTP response code: 401 for URL: https://staging-dashboard.paytm.com/bpay/api/v1/disburse/order/bank" == exp.getMessage()
    }


    def "test com.techsocialist.plugin.pg.paytm.response.BankTransferResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin()
        String orderId = String.format("OREDER-ID-%s", new Date().getTime())
        String subwalletGuid = UUID.randomUUID().toString();
        String beneficiaryAccount = "1234567890"
        String amount = "1000"
        String beneficiaryIFSC = "ICICI001"
        String purpose = ""
        String date = "2020-02-07"
        String callbackUrl = "http://localhost:8080/test"
        String comments = "no comments"
        String transferMode = "NEFT"
        String version = "v1"

        when:
        String jsonResponse = paymentGatewayRestPlugin.bankTransfer(merchantId, merchantKey, version, orderId, subwalletGuid, amount, beneficiaryAccount, beneficiaryIFSC, purpose, date, transferMode, callbackUrl, comments)
        BankTransferResponse bankTransferResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, BankTransferResponse.class)

        then:
        thrown(Exception)
        null == bankTransferResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.BankTransferResponse -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        BankTransferResponse bankTransferResponse = new BankTransferResponse()

        then:
        null == bankTransferResponse.getBankTransferResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.BankTransferResponse -> com.techsocialist.plugin.pg.paytm.response.body"(){

        when:
        BankTransferResponse bankTransferResponse = new BankTransferResponse()

        then:
        null == bankTransferResponse.getBankTransferResponseBody()
    }
}
