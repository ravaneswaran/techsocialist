package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class MandateFormDownloadResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)

        then:
        null != jsonString
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormDownloadResponse mandateFormDownloadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormDownloadResponse.class)

        then:
        null != mandateFormDownloadResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse -> ok()"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormDownloadResponse mandateFormDownloadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormDownloadResponse.class)

        then:
        false == mandateFormDownloadResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse -> mandateFormDownloadResponseHead"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormDownloadResponse mandateFormDownloadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormDownloadResponse.class)

        then:
        null != mandateFormDownloadResponse.getMandateFormDownloadResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse -> MandateFormDownloadResponseHead -> version"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormDownloadResponse mandateFormDownloadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormDownloadResponse.class)

        then:
        "v1" == mandateFormDownloadResponse.getMandateFormDownloadResponseHead().getVersion()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse -> MandateFormDownloadResponseHead -> timestamp"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormDownloadResponse mandateFormDownloadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormDownloadResponse.class)

        then:
        null != mandateFormDownloadResponse.getMandateFormDownloadResponseHead().getTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse -> MandateFormDownloadResponseBody"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormDownloadResponse mandateFormDownloadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormDownloadResponse.class)

        then:
        null != mandateFormDownloadResponse.getMandateFormDownloadResponseBody()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.MandateFormDownloadResponse -> MandateFormDownloadResponseBody -> resultInfo"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String subscriptionId = String.format("SUBSCRIPTION-ID-%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.mandateFormDownload(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, subscriptionId)
        MandateFormDownloadResponse mandateFormDownloadResponse = iUnmarshallerPlugin.unmarshall(jsonString, MandateFormDownloadResponse.class)

        then:
        null != mandateFormDownloadResponse.getMandateFormDownloadResponseBody().getResultInfo()
    }
}
