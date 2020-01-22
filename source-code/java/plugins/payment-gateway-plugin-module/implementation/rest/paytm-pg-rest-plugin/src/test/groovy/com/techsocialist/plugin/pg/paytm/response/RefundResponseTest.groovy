package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.AbstractPaytmPaymentGatewayTest
import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class RefundResponseTest extends AbstractPaytmPaymentGatewayTest{

    def "test refund as json string"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")

        then:
        null != jsonResponse
    }

    def "test RefundResponse"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        null != refundResponse
    }

    def "test RefundResponse ok"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        false == refundResponse.ok()
    }

    def "test RefundResponse -> RefundResponseHead"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        null != refundResponse.getRefundResponseHead()
    }

    def "test RefundResponse -> RefundResponseHead -> signature"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)
        String signature = refundResponse.getRefundResponseHead().getSignature()

        then:
        null != signature && signature.length() > 0
    }

    def "test RefundResponse -> RefundResponseBody"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        null != refundResponse.getRefundResponseBody()
    }

    def "test RefundResponse -> RefundResponseBody -> orderId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        orderId == refundResponse.getRefundResponseBody().getOrderId()
    }

    def "test RefundResponse -> RefundResponseBody -> mid"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        merchantId == refundResponse.getRefundResponseBody().getMerchantId()
    }

    def "test RefundResponse -> RefundResponseBody -> txnId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        transactionId == refundResponse.getRefundResponseBody().getTransactionId()
    }

    def "test RefundResponse -> RefundResponseBody -> refundAmount"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        "1000" == refundResponse.getRefundResponseBody().getRefundAmount()
    }

    def "test RefundResponse -> RefundResponseBody -> transactionTimestamp"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        null == refundResponse.getRefundResponseBody().getTransactionTimestamp()
    }

    def "test RefundResponse -> RefundResponseBody -> uniqueRefundId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        null == refundResponse.getRefundResponseBody().getUniqueRefundId()
    }

    def "test RefundResponse -> RefundResponseBody -> paytmRefundId"(){

        setup:
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def transactionId = String.format("TRANSACTION-ID-%s", new Date().getTime())
        def refundId = String.format("REFUND-ID-%s", new Date().getTime())
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.refund(merchantId, merchantKey, orderId, refundId, transactionId, "C11", "1000")
        RefundResponse refundResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RefundResponse.class)

        then:
        null == refundResponse.getRefundResponseBody().getPaytmRefundId()
    }
}
