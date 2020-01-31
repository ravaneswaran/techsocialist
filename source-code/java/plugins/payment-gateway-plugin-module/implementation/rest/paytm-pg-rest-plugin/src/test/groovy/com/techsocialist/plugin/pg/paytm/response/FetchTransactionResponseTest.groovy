package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class FetchTransactionResponseTest extends AbstractPaytmResponseTest{

    def "test FetchTransactionResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String pageNo = "10"
        String pageSize = "A4"
        String searchStartDate = "2020-01-01"
        String searchEndDate = "2021-12-31"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchTransaction(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, pageNo, pageSize, searchStartDate, searchEndDate)

        then:
        null != jsonResponse
    }

    def "test FetchTransactionResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String pageNo = "10"
        String pageSize = "A4"
        String searchStartDate = "2020-01-01"
        String searchEndDate = "2021-12-31"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchTransaction(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, pageNo, pageSize, searchStartDate, searchEndDate)
        FetchTransactionResponse fetchTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchTransactionResponse.class)

        then:
        null != fetchTransactionResponse
    }

    def "test FetchTransactionResponse -> ok"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String pageNo = "10"
        String pageSize = "A4"
        String searchStartDate = "2020-01-01"
        String searchEndDate = "2021-12-31"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchTransaction(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, pageNo, pageSize, searchStartDate, searchEndDate)
        FetchTransactionResponse fetchTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchTransactionResponse.class)

        then:
        false == fetchTransactionResponse.ok()
    }

    def "test FetchTransactionResponse -> fetchTransactionResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        String pageNo = "10"
        String pageSize = "A4"
        String searchStartDate = "2020-01-01"
        String searchEndDate = "2021-12-31"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchTransaction(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, pageNo, pageSize, searchStartDate, searchEndDate)
        FetchTransactionResponse fetchTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchTransactionResponse.class)

        then:
        null != fetchTransactionResponse.getFetchTransactionResponseHead()
    }
}