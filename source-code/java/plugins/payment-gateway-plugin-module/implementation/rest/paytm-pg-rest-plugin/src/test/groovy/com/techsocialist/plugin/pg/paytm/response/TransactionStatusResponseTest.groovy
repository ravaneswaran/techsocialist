package com.techsocialist.plugin.pg.paytm.response


import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class TransactionStatusResponseTest extends AbstractPaytmResponseTest {

    def "test TransactionStatusResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)

        then:
        null != jsonResponse
    }

    def "test TransactionStatusResponse"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        null != transactionStatusResponse
    }

    def "test TransactionStatusResponse transaction id"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionId()
    }

    def "test TransactionStatusResponse bank transaction id"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getBankTransactionId()
    }

    def "test TransactionStatusResponse order id"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        orderId == transactionStatusResponse.getOrderId()
    }

    def "test TransactionStatusResponse transaction amount"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionAmount()
    }

    def "test TransactionStatusResponse status"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "TXN_FAILURE" == transactionStatusResponse.getStatus()
    }

    def "test TransactionStatusResponse transaction type"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionType()
    }

    def "test TransactionStatusResponse gateway name"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getGatewayName()
    }

    def "test TransactionStatusResponse response code"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "334" == transactionStatusResponse.getResponseCode()
    }

    def "test TransactionStatusResponse response message"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "Invalid Order Id." == transactionStatusResponse.getResponseMessage()
    }

    def "test TransactionStatusResponse bank name"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getBankName()
    }

    def "test TransactionStatusResponse merchant id"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        merchantId == transactionStatusResponse.getMerchantId()
    }

    def "test TransactionStatusResponse payment mode"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getPaymentMode()
    }

    def "test TransactionStatusResponse refund amount"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getRefundAmount()
    }

    def "test TransactionStatusResponse transaction date"(){

        setup:
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())

        when:
        String jsonResponse = paymentGatewayRestPlugin.transactionStatus(merchantId, merchantKey, orderId)
        TransactionStatusResponse transactionStatusResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, TransactionStatusResponse.class)

        then:
        "" == transactionStatusResponse.getTransactionDate()
    }
}
