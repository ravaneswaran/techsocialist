package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class UpdateLinkResponseTest extends AbstractPaytmResponseTest{

    def "test UpdateLinkResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"
        String linkDescription = "A4"
        String expiryDate = "2021-12-31"
        String amount = "1000.00"

        when:
        String jsonResponse = paymentGatewayRestPlugin.updateLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId, linkDescription, expiryDate, amount)

        then:
        null != jsonResponse
    }

    def "test UpdateLinkResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"
        String linkDescription = "A4"
        String expiryDate = "2021-12-31"
        String amount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.updateLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId, linkDescription, expiryDate, amount)
        UpdateLinkResponse updateLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateLinkResponse.class)

        then:
        null != updateLinkResponse
    }

    def "test UpdateLinkResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"
        String linkDescription = "A4"
        String expiryDate = "2021-12-31"
        String amount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.updateLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId, linkDescription, expiryDate, amount)
        UpdateLinkResponse updateLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateLinkResponse.class)

        then:
        false == updateLinkResponse.ok()
    }

    def "test UpdateLinkResponse -> updateLinkResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"
        String linkDescription = "A4"
        String expiryDate = "2021-12-31"
        String amount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.updateLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId, linkDescription, expiryDate, amount)
        UpdateLinkResponse updateLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateLinkResponse.class)

        then:
        null != updateLinkResponse.getUpdateLinkResponseHead()
    }

    def "test UpdateLinkResponse -> updateLinkResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String merchantRequestId = "1234455"
        String linkDescription = "A4"
        String expiryDate = "2021-12-31"
        String amount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.updateLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, merchantRequestId, linkId, linkDescription, expiryDate, amount)
        UpdateLinkResponse updateLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, UpdateLinkResponse.class)

        then:
        null != updateLinkResponse.getUpdateLinkResponseBody()
    }

}
