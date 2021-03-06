package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class ValidateAssetResponseTest extends AbstractPaytmResponseTest {

    def "test com.techsocialist.plugin.pg.paytm.response.ValidateAssetResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String requestId = String.valueOf(new Date().getTime())
        String vpa = ""
        String customerAccountNumber = "3534983209483"
        String bankIfscCode = "dfsd34343"
        String customerFirstName = "firstname"
        String customerLastName = "lastname"
        String customerMobileNumber = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.validateAsset(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, requestId, vpa, customerAccountNumber, bankIfscCode, customerFirstName, customerLastName, customerMobileNumber)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ValidateAssetResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String requestId = String.valueOf(new Date().getTime())
        String vpa = "vpa"
        String customerAccountNumber = "3534983209483"
        String bankIfscCode = "dfsd34343"
        String customerFirstName = "firstname"
        String customerLastName = "lastname"
        String customerMobileNumber = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.validateAsset(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, requestId, vpa, customerAccountNumber, bankIfscCode, customerFirstName, customerLastName, customerMobileNumber)
        ValidateAssetResponse validateAssetResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, ValidateAssetResponse.class)

        then:
        null != validateAssetResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ValidateAssetResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String requestId = String.valueOf(new Date().getTime())
        String vpa = "vpa"
        String customerAccountNumber = "3534983209483"
        String bankIfscCode = "dfsd34343"
        String customerFirstName = "firstname"
        String customerLastName = "lastname"
        String customerMobileNumber = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.validateAsset(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, requestId, vpa, customerAccountNumber, bankIfscCode, customerFirstName, customerLastName, customerMobileNumber)
        ValidateAssetResponse validateAssetResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, ValidateAssetResponse.class)

        then:
        false == validateAssetResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ValidateAssetResponse -> validateAssetResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String requestId = String.valueOf(new Date().getTime())
        String vpa = "vpa"
        String customerAccountNumber = "3534983209483"
        String bankIfscCode = "dfsd34343"
        String customerFirstName = "firstname"
        String customerLastName = "lastname"
        String customerMobileNumber = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.validateAsset(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, requestId, vpa, customerAccountNumber, bankIfscCode, customerFirstName, customerLastName, customerMobileNumber)
        ValidateAssetResponse validateAssetResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, ValidateAssetResponse.class)

        then:
        null != validateAssetResponse.getValidateAssetResponseHead()
    }

}
