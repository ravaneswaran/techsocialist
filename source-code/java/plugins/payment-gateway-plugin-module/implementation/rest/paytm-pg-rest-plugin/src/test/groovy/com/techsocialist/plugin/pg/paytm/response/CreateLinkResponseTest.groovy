package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class CreateLinkResponseTest extends AbstractPaytmResponseTest {

    def "test CreateLinkResponse as json string"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)

        then:
        null != jsonResponse
    }

    def "test CreateLinkResponse as object"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null != createLinkResponse
    }

    def "test CreateLinkResponse -> ok()"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        false == createLinkResponse.ok()
    }

    def "test CreateLinkResponse -> createLinkResponseHead"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null != createLinkResponse.getCreateLinkResponseHead()
    }

    def "test CreateLinkResponse -> CreateLinkResponseHead -> version"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null != createLinkResponse.getCreateLinkResponseHead().getVersion()
    }

    def "test CreateLinkResponse -> CreateLinkResponseHead -> timestamp"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null != createLinkResponse.getCreateLinkResponseHead().getTimestamp()
    }

    def "test CreateLinkResponse -> CreateLinkResponseHead -> channelId"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null == createLinkResponse.getCreateLinkResponseHead().getChannelId()
    }

    def "test CreateLinkResponse -> CreateLinkResponseHead -> signature"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null == createLinkResponse.getCreateLinkResponseHead().getSignature()
    }

    def "test CreateLinkResponse -> CreateLinkResponseHead -> tokenType"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null == createLinkResponse.getCreateLinkResponseHead().getTokenType()
    }

    def "test CreateLinkResponse -> CreateLinkResponseHead -> clientId"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        String channelId = "WEB"
        String version = "v1"
        String requestTimestamp = String.valueOf(new Date().getTime())
        String tokenType = "AES"
        String merchantRequestId = String.valueOf(new Date().getTime())
        String linkName = "test link"
        String linkDescription = "test description"
        String linkType = "link Type"
        String txnAmount = "1000.00"
        String expiryDate = "2022-12-31"
        String statusCallbackUrl = "http://localhost:8080/test"
        String maxPaymentsAllowed = "10"
        boolean sendSMS = false
        boolean sendEmail = false
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()

        when:
        String jsonResponse = paymentGatewayRestPlugin.createLink(merchantId, merchantKey, channelId, version, requestTimestamp, tokenType, merchantRequestId, linkName, linkDescription, linkType, txnAmount, expiryDate, sendSMS, sendEmail, statusCallbackUrl, maxPaymentsAllowed)
        CreateLinkResponse createLinkResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, CreateLinkResponse.class)

        then:
        null == createLinkResponse.getCreateLinkResponseHead().getClientId()
    }



}
