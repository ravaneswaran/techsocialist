package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class FetchLinkResponseTest extends AbstractPaytmResponseTest {

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse as object"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)
        FetchLinkResponse response = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchLinkResponse.class)

        then:
        null != response
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse -> ok()"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)
        FetchLinkResponse response = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchLinkResponse.class)

        then:
        true == response.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse -> fetchLinkResponseHead"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)
        FetchLinkResponse response = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchLinkResponse.class)

        then:
        null != response.getFetchLinkResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse -> FetchLinkResponseHead -> timestamp"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)
        FetchLinkResponse response = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchLinkResponse.class)

        then:
        null != response.getFetchLinkResponseHead().getTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse -> FetchLinkResponseHead -> channelId"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)
        FetchLinkResponse response = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchLinkResponse.class)

        then:
        null == response.getFetchLinkResponseHead().getChannelId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse -> FetchLinkResponseHead -> tokenType"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)
        FetchLinkResponse response = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchLinkResponse.class)

        then:
        null != response.getFetchLinkResponseHead().getTokenType()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.FetchLinkResponse -> FetchLinkResponseHead -> clientId"(){

        setup:
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String linkDescription = "test description"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String pageNo = "10"
        String pageSize = "A4"
        String customerName = "test"
        String customerPhone = "42343"
        String customerEmail = "test@test.com"
        String paymentStatus = "Pending"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, linkDescription, merchantRequestId, pageNo, pageSize, customerName, customerPhone, customerEmail, paymentStatus)
        FetchLinkResponse response = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchLinkResponse.class)

        then:
        null == response.getFetchLinkResponseHead().getClientId()
    }
}
