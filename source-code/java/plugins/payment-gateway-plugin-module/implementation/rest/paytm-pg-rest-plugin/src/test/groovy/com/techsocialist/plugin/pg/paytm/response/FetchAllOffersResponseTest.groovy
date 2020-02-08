package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class FetchAllOffersResponseTest extends AbstractPaytmResponseTest{


    def "test FetchAllOffersResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String requestId = String.valueOf(new Date().getTime())
        String tokenType = "CHECKSUM"
        String token = String.format("%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchAllOffers(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, channelId, requestId)

        then:
        null != jsonString
    }

    def "test FetchAllOffersResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String requestId = String.valueOf(new Date().getTime())
        String tokenType = "CHECKSUM"
        String token = String.format("%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchAllOffers(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, channelId, requestId)
        FetchAllOffersResponse fetchSubscriptionStatusResponse = unmarshallerPlugin.unmarshall(jsonString, FetchAllOffersResponse.class)

        then:
        null != fetchSubscriptionStatusResponse
    }

    def "test FetchAllOffersResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String requestId = String.valueOf(new Date().getTime())
        String tokenType = "CHECKSUM"
        String token = String.format("%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchAllOffers(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, channelId, requestId)
        FetchAllOffersResponse fetchSubscriptionStatusResponse = unmarshallerPlugin.unmarshall(jsonString, FetchAllOffersResponse.class)

        then:
        true == fetchSubscriptionStatusResponse.ok()
    }

    def "test FetchAllOffersResponse -> fetchAllOffersResponse"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String requestId = String.valueOf(new Date().getTime())
        String tokenType = "CHECKSUM"
        String token = String.format("%s", new Date().getTime())

        when:
        String jsonString  = paymentGatewayRestPlugin.fetchAllOffers(merchantId, merchantKey, clientId, version, requestTimestamp, tokenType, token, channelId, requestId)
        FetchAllOffersResponse fetchSubscriptionStatusResponse = unmarshallerPlugin.unmarshall(jsonString, FetchAllOffersResponse.class)

        then:
        null != fetchSubscriptionStatusResponse.getFetchAllOffersResponseHead()
    }


}
