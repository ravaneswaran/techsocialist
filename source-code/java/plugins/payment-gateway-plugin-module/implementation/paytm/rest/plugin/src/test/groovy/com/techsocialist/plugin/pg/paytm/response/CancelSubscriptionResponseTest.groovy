package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.CancelSubscriptionResponseBody
import com.techsocialist.plugin.pg.paytm.response.head.CancelSubscriptionResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class CancelSubscriptionResponseTest extends AbstractPaytmResponseTest{

    def "test CancelSubscriptionResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)

        then:
        null != jsonResponse
    }

    def "test CancelSubscriptionResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)

        then:
        null != cancelSubscriptionResponse
    }

    def "test CancelSubscriptionResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)

        then:
        true == cancelSubscriptionResponse.ok()
    }

    def "test CancelSubscriptionResponse -> cancelSubscriptionResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseHead cancelSubscriptionResponseHead = cancelSubscriptionResponse.getCancelSubscriptionResponseHead()

        then:
        null != cancelSubscriptionResponseHead
    }

    def "test CancelSubscriptionResponse -> cancelSubscriptionResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseBody cancelSubscriptionResponseBody = cancelSubscriptionResponse.getCancelSubscriptionResponseBody()

        then:
        null != cancelSubscriptionResponseBody
    }

    def "test CancelSubscriptionResponse -> CancelSubscriptionResponseBody -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseBody cancelSubscriptionResponseBody = cancelSubscriptionResponse.getCancelSubscriptionResponseBody()

        then:
        true == cancelSubscriptionResponseBody.ok()
    }

    def "test CancelSubscriptionResponse -> CancelSubscriptionResponseBody -> merchantId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseBody cancelSubscriptionResponseBody = cancelSubscriptionResponse.getCancelSubscriptionResponseBody()

        then:
        null == cancelSubscriptionResponseBody.getMerchantId()
    }

    def "test CancelSubscriptionResponse -> CancelSubscriptionResponseBody -> subscriptionId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseBody cancelSubscriptionResponseBody = cancelSubscriptionResponse.getCancelSubscriptionResponseBody()

        then:
        null == cancelSubscriptionResponseBody.getSubscriptionId()
    }

    def "test CancelSubscriptionResponse -> CancelSubscriptionResponseBody -> customerId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseBody cancelSubscriptionResponseBody = cancelSubscriptionResponse.getCancelSubscriptionResponseBody()

        then:
        null == cancelSubscriptionResponseBody.getCustomerId()
    }

    def "test CancelSubscriptionResponse -> CancelSubscriptionResponseBody -> createdDate"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseBody cancelSubscriptionResponseBody = cancelSubscriptionResponse.getCancelSubscriptionResponseBody()

        then:
        null == cancelSubscriptionResponseBody.getCreatedDate()
    }

    def "test CancelSubscriptionResponse -> CancelSubscriptionResponseBody -> expiryDate"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String subscriptionId = "1234557"
        String ssoToken = "ssoToken"

        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.cancelSubscription(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, subscriptionId, ssoToken)
        CancelSubscriptionResponse cancelSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CancelSubscriptionResponse.class)
        CancelSubscriptionResponseBody cancelSubscriptionResponseBody = cancelSubscriptionResponse.getCancelSubscriptionResponseBody()

        then:
        null == cancelSubscriptionResponseBody.getExpiryDate()
    }
}
