package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.InitiateSubscriptionResponseBody
import com.techsocialist.plugin.pg.paytm.response.head.InitiateSubscriptionResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class InitiateSubscriptionResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)

        then:
        null != jsonResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)

        then:
        null != initiateSubscriptionResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseHead initiateSubscriptionResponseHead = initiateSubscriptionResponse.getInitiateSubscriptionResponseHead()

        then:
        null != initiateSubscriptionResponseHead
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseHead -> requestId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseHead initiateSubscriptionResponseHead = initiateSubscriptionResponse.getInitiateSubscriptionResponseHead()

        then:
        null == initiateSubscriptionResponseHead.getRequestId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseHead initiateSubscriptionResponseHead = initiateSubscriptionResponse.getInitiateSubscriptionResponseHead()

        then:
        null != initiateSubscriptionResponseHead.getResponseTimestamp()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseHead initiateSubscriptionResponseHead = initiateSubscriptionResponse.getInitiateSubscriptionResponseHead()

        then:
        "v1" == initiateSubscriptionResponseHead.getVersion()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseBody initiateSubscriptionResponseBody = initiateSubscriptionResponse.getInitiateSubscriptionResponseBody()

        then:
        null != initiateSubscriptionResponseBody
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseBody -> extraParamsMap"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseBody initiateSubscriptionResponseBody = initiateSubscriptionResponse.getInitiateSubscriptionResponseBody()

        then:
        null == initiateSubscriptionResponseBody.getExtraParamsMap()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseBody -> resultInfo"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseBody initiateSubscriptionResponseBody = initiateSubscriptionResponse.getInitiateSubscriptionResponseBody()

        then:
        null != initiateSubscriptionResponseBody.getResultInfo()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseBody -> ResultInfo -> resultStatus"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseBody initiateSubscriptionResponseBody = initiateSubscriptionResponse.getInitiateSubscriptionResponseBody()

        then:
        "U" == initiateSubscriptionResponseBody.getResultInfo().getResultStatus()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseBody -> ResultInfo -> resultCode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseBody initiateSubscriptionResponseBody = initiateSubscriptionResponse.getInitiateSubscriptionResponseBody()

        then:
        "00000900" == initiateSubscriptionResponseBody.getResultInfo().getResultCode()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.InitiateSubscriptionResponse -> InitiateSubscriptionResponseBody -> ResultInfo -> resultMessage"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()

        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def transactionAmount = "1000"
        def subscriptionMaxAmount = "2000"
        def subscriptionPaymentMode = "CC"
        def subscriptionAmountType = "FIX"
        def subscriptionFrequency = "2"
        def subscriptionFrequencyUnit = "MONTH"
        def subscriptionStartDate = "2020-01-01"
        def subscriptionExpiryDate = "2020-12-31"
        def subscriptionGraceDays = "05"
        def subscriptionEnableRetry = "1"
        def subscriptionRetryCount = "05"
        def subscriptionCallbackURL = callbackUrl

        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.initiateSubscription(merchantId, merchantKey, customerId, orderId, currency, transactionAmount, subscriptionMaxAmount, subscriptionPaymentMode, subscriptionAmountType, subscriptionFrequency, subscriptionFrequencyUnit, subscriptionStartDate, subscriptionExpiryDate, subscriptionGraceDays, subscriptionEnableRetry, subscriptionRetryCount, subscriptionCallbackURL)
        InitiateSubscriptionResponse initiateSubscriptionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateSubscriptionResponse.class)
        InitiateSubscriptionResponseBody initiateSubscriptionResponseBody = initiateSubscriptionResponse.getInitiateSubscriptionResponseBody()

        then:
        "System error" == initiateSubscriptionResponseBody.getResultInfo().getResultMessage()
    }

}
