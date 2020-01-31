package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.FetchInstrumentResponseBody
import com.techsocialist.plugin.pg.paytm.response.head.FetchInstrumentResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class FetchInstrumentResponseTest extends AbstractPaytmResponseTest {

    def "test FetchInstrumentResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)

        then:
        null != jsonResponse
    }

    def "test FetchInstrumentResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)

        then:
        null != fetchInstrumentResponse
    }

    def "test FetchInstrumentResponse -> fetchInstrumentResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseHead fetchInstrumentResponseHead = fetchInstrumentResponse.getFetchInstrumentResponseHead()

        then:
        null != fetchInstrumentResponseHead
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseHead fetchInstrumentResponseHead = fetchInstrumentResponse.getFetchInstrumentResponseHead()

        then:
        null != fetchInstrumentResponseHead.getResponseTimestamp()
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseHead fetchInstrumentResponseHead = fetchInstrumentResponse.getFetchInstrumentResponseHead()

        then:
        null != fetchInstrumentResponseHead.getVersion()
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseHead -> clientId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseHead fetchInstrumentResponseHead = fetchInstrumentResponse.getFetchInstrumentResponseHead()

        then:
        null != fetchInstrumentResponseHead.getClientId()
    }

    def "test FetchInstrumentResponse -> fetchInstrumentResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseBody fetchInstrumentResponseBody = fetchInstrumentResponse.getFetchInstrumentResponseBody()

        then:
        null != fetchInstrumentResponseBody
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseBody -> resultInfo"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseBody fetchInstrumentResponseBody = fetchInstrumentResponse.getFetchInstrumentResponseBody()

        then:
        null != fetchInstrumentResponseBody.getResultInfo()
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseBody -> ResultInfo -> resultStatus"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseBody fetchInstrumentResponseBody = fetchInstrumentResponse.getFetchInstrumentResponseBody()

        then:
        null != fetchInstrumentResponseBody.getResultInfo().getResultStatus()
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseBody -> ResultInfo -> resultCode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseBody fetchInstrumentResponseBody = fetchInstrumentResponse.getFetchInstrumentResponseBody()

        then:
        null != fetchInstrumentResponseBody.getResultInfo().getResultCode()
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseBody -> ResultInfo -> resultMessage"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseBody fetchInstrumentResponseBody = fetchInstrumentResponse.getFetchInstrumentResponseBody()

        then:
        null != fetchInstrumentResponseBody.getResultInfo().getResultMessage()
    }

    def "test FetchInstrumentResponse -> FetchInstrumentResponseBody -> payOptions"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String userToken = "AES"
        String transactionAmount = "1000.00"
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.fetchInstrument(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, userToken, transactionAmount)
        FetchInstrumentResponse fetchInstrumentResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchInstrumentResponse.class)
        FetchInstrumentResponseBody fetchInstrumentResponseBody = fetchInstrumentResponse.getFetchInstrumentResponseBody()

        then:
        null == fetchInstrumentResponseBody.getPayOptions()
    }
}
