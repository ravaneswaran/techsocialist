package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class ExpireLinkResponseTest extends AbstractPaytmResponseTest {

    def "test ExpireLinkResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"

        when:
        String jsonResponse = paymentGatewayRestPlugin.expireLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId)

        then:
        null != jsonResponse
    }

    def "test ExpireLinkResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"

        when:
        String jsonResponse = paymentGatewayRestPlugin.expireLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId)
        ExpireLinkResponse expireLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ExpireLinkResponse.class)

        then:
        null != expireLinkResponse
    }

    def "test ExpireLinkResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"

        when:
        String jsonResponse = paymentGatewayRestPlugin.expireLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId)
        ExpireLinkResponse expireLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ExpireLinkResponse.class)

        then:
        false == expireLinkResponse.ok()
    }

    def "test ExpireLinkResponse -> expireLinkResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"

        when:
        String jsonResponse = paymentGatewayRestPlugin.expireLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId)
        ExpireLinkResponse expireLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ExpireLinkResponse.class)

        then:
        null != expireLinkResponse.getExpireLinkResponseHead()
    }

}
