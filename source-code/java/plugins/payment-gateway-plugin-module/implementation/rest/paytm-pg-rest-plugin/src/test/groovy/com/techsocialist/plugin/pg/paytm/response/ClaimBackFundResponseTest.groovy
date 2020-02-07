package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class ClaimBackFundResponseTest extends AbstractPaytmResponseTest{

    def "test ClaimBackFundResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String subwalletGuid = UUID.randomUUID().toString()
        String amount = "1000"

        when:
        paymentGatewayRestPlugin.claimBackFund(merchantId, merchantKey, subwalletGuid, amount)

        then:
        Exception exp = thrown()
        "Server returned HTTP response code: 401 for URL: https://staging-dashboard.paytm.com/bpay/api/v1/account/debit" == exp.getMessage()
    }

    def "test ClaimBackFundResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String subwalletGuid = UUID.randomUUID().toString()
        String amount = "1000"

        when:
        String jsonResponse = paymentGatewayRestPlugin.claimBackFund(merchantId, merchantKey, subwalletGuid, amount)
        ClaimBackFundResponse claimBackFundResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, ClaimBackFundResponse.class)

        then:
        thrown(Exception)
        null == claimBackFundResponse
    }

    def "test ClaimBackFundResponse -> head"(){

        when:
        ClaimBackFundResponse claimBackFundResponse = new ClaimBackFundResponse()

        then:
        null == claimBackFundResponse.getClaimBackFundResponseHead()
    }

    def "test ClaimBackFundResponse -> body"(){

        when:
        ClaimBackFundResponse claimBackFundResponse = new ClaimBackFundResponse()

        then:
        null == claimBackFundResponse.getClaimBackFundResponseBody()
    }

}
