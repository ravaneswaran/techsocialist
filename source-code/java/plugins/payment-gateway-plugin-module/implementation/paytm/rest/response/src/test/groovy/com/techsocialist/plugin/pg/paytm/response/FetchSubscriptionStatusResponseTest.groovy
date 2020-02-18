package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class FetchSubscriptionStatusResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.FetchSubscriptionStatusResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String token = String.format("%s", new Date().getTime())
        String customerId = "CUSTOMER-ID-001"
        String subscriptionId = "SUBSCRIPTION-ID-001"

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchSubscriptionStatus(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, customerId, subscriptionId)

        then:
        null != jsonString
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchSubscriptionStatusResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String token = String.format("%s", new Date().getTime())
        String customerId = "CUSTOMER-ID-001"
        String subscriptionId = "SUBSCRIPTION-ID-001"

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchSubscriptionStatus(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, customerId, subscriptionId)
        FetchSubscriptionStatusResponse fetchSubscriptionStatusResponse = iUnmarshallerPlugin.unmarshall(jsonString, FetchSubscriptionStatusResponse.class)

        then:
        null != fetchSubscriptionStatusResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchSubscriptionStatusResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String token = String.format("%s", new Date().getTime())
        String customerId = "CUSTOMER-ID-001"
        String subscriptionId = "SUBSCRIPTION-ID-001"

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchSubscriptionStatus(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, customerId, subscriptionId)
        FetchSubscriptionStatusResponse fetchSubscriptionStatusResponse = iUnmarshallerPlugin.unmarshall(jsonString, FetchSubscriptionStatusResponse.class)

        then:
        null != fetchSubscriptionStatusResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchSubscriptionStatusResponse -> fetchSubscriptionStatusResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String token = String.format("%s", new Date().getTime())
        String customerId = "CUSTOMER-ID-001"
        String subscriptionId = "SUBSCRIPTION-ID-001"

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchSubscriptionStatus(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, customerId, subscriptionId)
        FetchSubscriptionStatusResponse fetchSubscriptionStatusResponse = iUnmarshallerPlugin.unmarshall(jsonString, FetchSubscriptionStatusResponse.class)

        then:
        null != fetchSubscriptionStatusResponse.getFetchSubscriptionStatusResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchSubscriptionStatusResponse -> FetchSubscriptionStatusResponseHead -> timestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String token = String.format("%s", new Date().getTime())
        String customerId = "CUSTOMER-ID-001"
        String subscriptionId = "SUBSCRIPTION-ID-001"

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchSubscriptionStatus(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, customerId, subscriptionId)
        FetchSubscriptionStatusResponse fetchSubscriptionStatusResponse = iUnmarshallerPlugin.unmarshall(jsonString, FetchSubscriptionStatusResponse.class)

        then:
        null != fetchSubscriptionStatusResponse.getFetchSubscriptionStatusResponseHead().getTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchSubscriptionStatusResponse -> FetchSubscriptionStatusResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String token = String.format("%s", new Date().getTime())
        String customerId = "CUSTOMER-ID-001"
        String subscriptionId = "SUBSCRIPTION-ID-001"

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchSubscriptionStatus(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, customerId, subscriptionId)
        FetchSubscriptionStatusResponse fetchSubscriptionStatusResponse = iUnmarshallerPlugin.unmarshall(jsonString, FetchSubscriptionStatusResponse.class)

        then:
        null != fetchSubscriptionStatusResponse.getFetchSubscriptionStatusResponseBody()
    }
}
