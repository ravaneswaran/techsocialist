package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class AccountListResponseTest extends AbstractPaytmResponseTest {

    def "test AccountListResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String subwalletGuid = UUID.randomUUID().toString()
        String version = "v1"
        String amount = "1000"

        when:
        paymentGatewayRestPlugin.accountList(merchantId, merchantKey, version, subwalletGuid)

        then:
        Exception exp = thrown()
        "Server returned HTTP response code: 401 for URL: https://staging-dashboard.paytm.com/bpay/api/v1/account/list" == exp.getMessage()
    }

    def "test AccountListResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String subwalletGuid = UUID.randomUUID().toString()

        when:
        String jsonResponse = paymentGatewayRestPlugin.addFund(merchantId, merchantKey, subwalletGuid)
        AccountListResponse accountListResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, AccountListResponse.class)

        then:
        thrown(Exception)
        null == accountListResponse
    }

    def "test AccountListResponse -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        AccountListResponse accountListResponse = new AccountListResponse()

        then:
        null == accountListResponse.getAccountListResponseHead()
    }

    def "test AccountListResponse -> com.techsocialist.plugin.pg.paytm.response.body"(){

        when:
        AccountListResponse accountListResponse = new AccountListResponse()

        then:
        null == accountListResponse.getAccountListResponseBody()
    }

}
