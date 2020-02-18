package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class MandateFormUploadResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormUpload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)

        then:
        null != jsonString
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse as object"(){

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
        MandateFormUploadResponse mandateFormUploadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormUploadResponse.class)

        then:
        null != mandateFormUploadResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse -> ok()"(){

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
        MandateFormUploadResponse mandateFormUploadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormUploadResponse.class)

        then:
        false == mandateFormUploadResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse -> mandateFormUploadResponseHead"(){

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
        MandateFormUploadResponse mandateFormUploadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormUploadResponse.class)

        then:
        null != mandateFormUploadResponse.getMandateFormUploadResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse -> mandateFormUploadResponseBody -> version"(){

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
        MandateFormUploadResponse mandateFormUploadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormUploadResponse.class)

        then:
        "v1" == mandateFormUploadResponse.getMandateFormUploadResponseHead().getVersion()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse -> MandateFormUploadResponseHead -> timestamp"(){

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
        MandateFormUploadResponse mandateFormUploadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormUploadResponse.class)

        then:
        null != mandateFormUploadResponse.getMandateFormUploadResponseHead().getTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse -> MandateFormUploadResponseBody"(){

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
        MandateFormUploadResponse mandateFormUploadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormUploadResponse.class)

        then:
        null != mandateFormUploadResponse.getMandateFormUploadResponseBody()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormUploadResponse -> MandateFormUploadResponseBody -> resultInfo"(){

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
        MandateFormUploadResponse mandateFormUploadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormUploadResponse.class)

        then:
        null != mandateFormUploadResponse.getMandateFormUploadResponseBody().getResultInfo()
    }
}
