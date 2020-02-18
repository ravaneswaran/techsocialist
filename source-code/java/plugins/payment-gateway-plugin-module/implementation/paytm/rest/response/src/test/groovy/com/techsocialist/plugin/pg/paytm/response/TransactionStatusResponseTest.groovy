package com.techsocialist.plugin.pg.paytm.response


import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class TransactionStatusResponseTest extends AbstractPaytmResponseTest {

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        null != transactionStatusResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse transaction id"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse bank transaction id"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getBankTransactionId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse order id"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        orderId == transactionStatusResponse.getOrderId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse transaction amount"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionAmount()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse status"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "TXN_FAILURE" == transactionStatusResponse.getStatus()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse transaction type"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionType()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse gateway name"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getGatewayName()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse response code"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "334" == transactionStatusResponse.getResponseCode()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse response message"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "Invalid Order Id." == transactionStatusResponse.getResponseMessage()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse bank name"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getBankName()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse merchant id"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        merchantId == transactionStatusResponse.getMerchantId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse payment mode"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getPaymentMode()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse refund amount"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getRefundAmount()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.TransactionStatusResponse transaction date"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionDate()
    }
}
