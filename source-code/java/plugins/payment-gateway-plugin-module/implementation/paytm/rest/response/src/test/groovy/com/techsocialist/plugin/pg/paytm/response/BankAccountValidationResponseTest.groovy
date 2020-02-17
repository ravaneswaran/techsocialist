package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class BankAccountValidationResponseTest extends AbstractPaytmResponseTest {

    def "test BankAccountValidationResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String orderId = String.format("OREDER-ID-%s", new Date().getTime())
        String subwalletGuid = UUID.randomUUID().toString();
        String beneficiaryAccount = "1234567890"
        String beneficiaryIFSC = "ICICI001"
        String beneficiaryVPA = "vpa"
        String callbackUrl = "http://localhost:8080/test"
        String version = "v1"

        when:
        paymentGatewayRestPlugin.bankAccountValidation(merchantId, merchantKey, version, orderId, subwalletGuid, beneficiaryAccount, beneficiaryIFSC, beneficiaryVPA, callbackUrl)

        then:
        Exception exp = thrown()
        "Server returned HTTP response code: 401 for URL: https://staging-dashboard.paytm.com/bpay/api/v1/beneficiary/validate" == exp.getMessage()
    }

    def "test BankAccountValidationResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String orderId = String.format("OREDER-ID-%s", new Date().getTime())
        String subwalletGuid = UUID.randomUUID().toString();
        String beneficiaryAccount = "1234567890"
        String beneficiaryIFSC = "ICICI001"
        String beneficiaryVPA = "vpa"
        String callbackUrl = "http://localhost:8080/test"
        String version = "v1"

        when:
        String jsonResponse = paymentGatewayRestPlugin.bankAccountValidation(merchantId, merchantKey, version, orderId, subwalletGuid, beneficiaryAccount, beneficiaryIFSC, beneficiaryVPA, callbackUrl)
        BankAccountValidationResponse bankAccountValidationResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, BankAccountValidationResponse.class)

        then:
        thrown(Exception)
        null == bankAccountValidationResponse
    }

    def "test BankAccountValidationResponse -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        BankAccountValidationResponse bankAccountValidationResponse = new BankAccountValidationResponse()

        then:
        null == bankAccountValidationResponse.getBankAccountValidationResponseHead()
    }

    def "test BankAccountValidationResponse -> com.techsocialist.plugin.pg.paytm.response.body"(){

        when:
        BankAccountValidationResponse bankAccountValidationResponse = new BankAccountValidationResponse()

        then:
        null == bankAccountValidationResponse.getBankAccountValidationResponseBody()
    }

}
