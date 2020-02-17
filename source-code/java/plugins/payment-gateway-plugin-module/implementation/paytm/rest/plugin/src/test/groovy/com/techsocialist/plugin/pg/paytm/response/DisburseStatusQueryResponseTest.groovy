package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class DisburseStatusQueryResponseTest extends AbstractPaytmResponseTest{

    def "test DisburseStatusQueryResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String version = "v1"
        String orderId = String.format("OREDER-ID-%s", new Date().getTime())

        when:
        paymentGatewayRestPlugin.disburseStatusQuery(merchantId, merchantKey, version, orderId)

        then:
        Exception exp = thrown()
        "Server returned HTTP response code: 401 for URL: https://staging-dashboard.paytm.com/bpay/api/v1/disburse/order/query" == exp.getMessage()
    }

    def "test DisburseStatusQueryResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String orderId = "ORDER-ID-001"
        String version = "v1"

        when:
        String jsonResponse = paymentGatewayRestPlugin.disburseStatusQuery(merchantId, merchantKey, version, orderId)
        DisburseStatusQueryResponse disburseStatusQueryResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, DisburseStatusQueryResponse.class)

        then:
        thrown(Exception)
        null == disburseStatusQueryResponse
    }

    def "test DisburseStatusQueryResponse -> com.techsocialist.plugin.pg.paytm.response.head"(){

        when:
        DisburseStatusQueryResponse disburseStatusQueryResponse = new DisburseStatusQueryResponse()

        then:
        null == disburseStatusQueryResponse.getDisburseStatusQueryResponseHead()
    }

    def "test DisburseStatusQueryResponse -> com.techsocialist.plugin.pg.paytm.response.body"(){

        when:
        DisburseStatusQueryResponse disburseStatusQueryResponse = new DisburseStatusQueryResponse()

        then:
        null == disburseStatusQueryResponse.getDisburseStatusQueryResponseBody()
    }

}
