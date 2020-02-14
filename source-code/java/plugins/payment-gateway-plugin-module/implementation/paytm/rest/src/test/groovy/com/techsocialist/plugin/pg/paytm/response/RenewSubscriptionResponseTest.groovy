package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class RenewSubscriptionResponseTest extends AbstractPaytmResponseTest {

    def "test RenewSubscriptionResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)

        then:
        null != jsonResponse
    }

    def "test RenewSubscriptionResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        null != renewSubscriptionResponse
    }

    def "test RenewSubscriptionResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        false == renewSubscriptionResponse.ok()
    }

    def "test RenewSubscriptionResponse -> renewSubscriptionResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        null != renewSubscriptionResponse.getRenewSubscriptionResponseHead()
    }

    def "test RenewSubscriptionResponse -> RenewSubscriptionResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        null != renewSubscriptionResponse.getRenewSubscriptionResponseHead().getResponseTimestamp()
    }

    def "test RenewSubscriptionResponse -> RenewSubscriptionResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        null != renewSubscriptionResponse.getRenewSubscriptionResponseHead().getVersion()
    }

    def "test RenewSubscriptionResponse -> RenewSubscriptionResponseHead -> signature"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        null == renewSubscriptionResponse.getRenewSubscriptionResponseHead().getSignature()
    }

    def "test RenewSubscriptionResponse -> renewSubscriptionResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        null != renewSubscriptionResponse.getRenewSubscriptionResponseBody()
    }

    def "test RenewSubscriptionResponse -> RenewSubscriptionResponseBody -> transactionId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String transactionAmount = "1000.00"
        String currency = "INR"
        String subscriptionId = "123"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.renewSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, orderId, transactionAmount, currency, subscriptionId)
        RenewSubscriptionResponse renewSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, RenewSubscriptionResponse.class)

        then:
        null == renewSubscriptionResponse.getRenewSubscriptionResponseBody().getTransactionId()
    }
}
