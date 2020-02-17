package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class MandateFormNotifyResponseTest extends AbstractPaytmResponseTest {

    def "test MandateFormNotifyResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormNotify(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)

        then:
        null != jsonString
    }

    def "test MandateFormNotifyResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormUpload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormNotifyResponse mandateFormNotifyResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormNotifyResponse.class)

        then:
        null != mandateFormNotifyResponse
    }

    def "test MandateFormNotifyResponse -> ok()"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormUpload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormNotifyResponse mandateFormNotifyResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormNotifyResponse.class)

        then:
        false == mandateFormNotifyResponse.ok()
    }

    def "test MandateFormNotifyResponse -> mandateFormNotifyResponseHead"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormUpload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormNotifyResponse mandateFormNotifyResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormNotifyResponse.class)

        then:
        null != mandateFormNotifyResponse.getMandateFormNotifyResponseHead()
    }

    def "test MandateFormNotifyResponse -> MandateFormNotifyResponseHead -> timestamp"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormUpload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormNotifyResponse mandateFormNotifyResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormNotifyResponse.class)

        then:
        null != mandateFormNotifyResponse.getMandateFormNotifyResponseHead().getTimestamp()
    }

    def "test MandateFormNotifyResponse -> mandateFormNotifyResponseBody"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormUpload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormNotifyResponse mandateFormNotifyResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormNotifyResponse.class)

        then:
        null != mandateFormNotifyResponse.getMandateFormNotifyResponseBody()
    }

}
