package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class ResendNotificationLinkResponseTest extends AbstractPaytmResponseTest {

    def "test com.techsocialist.plugin.pg.paytm.response.ResendNotificationLinkResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        boolean sendSMS = false
        boolean sendEmail = false
        String customerName = "test"
        String customerEmail = "test@test.com"
        String customerMobile = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.resendNotificationLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, sendSMS, sendEmail, customerName, customerEmail, customerMobile)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ResendNotificationLinkResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        boolean sendSMS = false
        boolean sendEmail = false
        String customerName = "test"
        String customerEmail = "test@test.com"
        String customerMobileNumber = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.resendNotificationLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, sendSMS, sendEmail, customerName, customerEmail, customerMobileNumber)
        ResendNotificationLinkResponse resendNotificationLinkResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, ResendNotificationLinkResponse.class)

        then:
        null != resendNotificationLinkResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ResendNotificationLinkResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        boolean sendSMS = false
        boolean sendEmail = false
        String customerName = "test"
        String customerEmail = "test@test.com"
        String customerMobileNumber = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.resendNotificationLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, sendSMS, sendEmail, customerName, customerEmail, customerMobileNumber)
        ResendNotificationLinkResponse resendNotificationLinkResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, ResendNotificationLinkResponse.class)

        then:
        true == resendNotificationLinkResponse.ok()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ResendNotificationLinkResponse -> resendNotificationLinkResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        IUnmarshallerPlugin iUnmarshallerPlugin = new GoogleUnmarshallerPlugin();
        String clientId = "C11"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String tokenType = "AES"
        String linkId = "123"
        boolean sendSMS = false
        boolean sendEmail = false
        String customerName = "test"
        String customerEmail = "test@test.com"
        String customerMobileNumber = "1234567890"

        when:
        String jsonResponse = paymentGatewayRestPlugin.resendNotificationLink(merchantId, merchantKey, clientId, version, requestTimestamp, channelId, tokenType, linkId, sendSMS, sendEmail, customerName, customerEmail, customerMobileNumber)
        ResendNotificationLinkResponse resendNotificationLinkResponse = iUnmarshallerPlugin.unmarshall(jsonResponse, ResendNotificationLinkResponse.class)

        then:
        null != resendNotificationLinkResponse.getResendNotificationLinkResponseHead()
    }

}
