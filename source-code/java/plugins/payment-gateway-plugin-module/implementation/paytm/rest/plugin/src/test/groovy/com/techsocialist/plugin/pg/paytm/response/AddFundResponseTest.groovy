package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class AddFundResponseTest extends AbstractPaytmResponseTest{

    def "test AddFundResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String subwalletGuid = UUID.randomUUID().toString()
        String amount = "1000"
        String version = "v1"

        when:
        paymentGatewayRestPlugin.addFund(merchantId, merchantKey, version, subwalletGuid, amount)

        then:
        Exception exp = thrown()
        "Server returned HTTP response code: 401 for URL: https://staging-dashboard.paytm.com/bpay/api/v1/account/credit" == exp.getMessage()
    }

    def "test AddFundResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String subwalletGuid = UUID.randomUUID().toString()
        String amount = "1000"

        when:
        String jsonResponse = paymentGatewayRestPlugin.addFund(merchantId, merchantKey, subwalletGuid, amount)
        AddFundResponse addFundResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, AddFundResponse.class)

        then:
        thrown(Exception)
        null == addFundResponse
    }

    def "test AddFundResponse -> head"(){

        when:
        AddFundResponse addFundResponse = new AddFundResponse()

        then:
        null == addFundResponse.getAddFundResponseHead()
    }

    def "test AddFundResponse -> body"(){

        when:
        AddFundResponse addFundResponse = new AddFundResponse()

        then:
        null == addFundResponse.getAddFundResponseBody()
    }

}
