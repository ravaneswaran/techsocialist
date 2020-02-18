package com.techsocialist.plugin.pg.paytm.response


import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class RefundStatusResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse as json string"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse as an object"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null != refundStatusResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse ok()"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        false == refundStatusResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseHead"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null != refundStatusResponse.getRefundStatusResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseHead -> signature"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)
        String signature = refundStatusResponse.getRefundStatusResponseHead().getSignature()

        then:
        null != signature && signature.length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null != refundStatusResponse.getRefundStatusResponseBody()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> orderId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        orderId == refundStatusResponse.getRefundStatusResponseBody().getOrderId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> userCreditInitiateStatus"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getUserCreditInitiateStatus()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> merchantId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null != refundStatusResponse.getRefundStatusResponseBody().getMerchantId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> merchantRefundRequestTimestamp"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getMerchantRefundRequestTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> transactionTimestamp"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getTransactionTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> acceptRefundTimestamp"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getAcceptRefundTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> acceptRefundStatus"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getAcceptRefundStatus()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> userCreditInitiateTimestamp"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getUserCreditInitiateTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> totalRefundAmount"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getTotalRefundAmount()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> uniqueRefundId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        refundId == refundStatusResponse.getRefundStatusResponseBody().getUniqueRefundId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> transactionAmount"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getTransactionAmount()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> paytmRefundId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getPaytmRefundId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> transactionId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getTransactionId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> refundAmount"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getRefundAmount()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> refundDetailInfoList"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getRefundDetailInfoList()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.RefundStatusResponse -> RefundStatusResponseBody -> RefundDetailInfo"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        def clientId = "C11"
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refundStatus(merchantId, merchantKey, orderId, refundId, clientId)
        RefundStatusResponse refundStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundStatusResponse.class)

        then:
        null == refundStatusResponse.getRefundStatusResponseBody().getRefundDetailInfoList()
    }

}
