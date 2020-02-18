package com.techsocialist.plugin.pg.paytm.response


import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.ProcessTransactionResponseBody
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.BankForm
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.TransactionInfo
import com.techsocialist.plugin.pg.paytm.response.head.ProcessTransactionResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class ProcessTransactionResponseTest extends AbstractPaytmResponseTest {

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse as json string"(){
        setup:

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)

        then:
        null != jsonResponse && jsonResponse.length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse as object"(){
        setup:

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)

        then:
        null != processTransactionResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseHead"(){
        setup:

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseHead processTransactionResponseHead = processTransactionResponse.getProcessTransactionResponseHead()

        then:
        null != processTransactionResponseHead
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseHead -> responseTimestamp"(){
        setup:

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseHead processTransactionResponseHead = processTransactionResponse.getProcessTransactionResponseHead()

        then:
        null != processTransactionResponseHead.getResponseTimestamp() && processTransactionResponseHead.getResponseTimestamp().length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseHead -> version"(){
        setup:

        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseHead processTransactionResponseHead = processTransactionResponse.getProcessTransactionResponseHead()

        then:
        null != processTransactionResponseHead.getVersion() && "v1" == processTransactionResponseHead.getVersion()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()

        then:
        null != processTransactionResponseBody
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> callBackUrl"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()

        then:
        null != processTransactionResponseBody.getCallBackUrl() && processTransactionResponseBody.getCallBackUrl().length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> bankForm"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        BankForm bankForm = processTransactionResponseBody.getBankForm()

        then:
        null == bankForm
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> txnInfo"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> bankTransactionId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getBankTransactionId() && "".equals(transactionInfo.getBankTransactionId())
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> checkSumHash"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getCheckSumHash() && transactionInfo.getCheckSumHash().length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> currency"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getCurrency() && "INR".equals(transactionInfo.getCurrency())
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> merchantId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getMerchantId() && merchantId == transactionInfo.getMerchantId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> orderId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getOrderId() && orderId == transactionInfo.getOrderId()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> responseCode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getResponseCode() && transactionInfo.getResponseCode().length() > 0
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> responseMessage"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getResponseMessage() && "Payment failed due to a technical error. Please try after some time." == transactionInfo.getResponseMessage()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> status"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getStatus() && "TXN_FAILURE" == transactionInfo.getStatus()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ProcessTransactionResponse -> ProcessTransactionResponseBody -> TransactionInfo -> transactionAmount"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        def transactionToken = initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken()
        def paymentMode = "NET_BANKING"
        def authMode = ""
        def cardInfo = ""
        def requestType = "NATIVE"

        when:
        jsonResponse = paymentGatewayRestPlugin.processTransaction(merchantId, merchantKey, orderId, transactionToken, paymentMode, authMode, cardInfo, requestType)
        ProcessTransactionResponse processTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, ProcessTransactionResponse.class)
        ProcessTransactionResponseBody processTransactionResponseBody = processTransactionResponse.getProcessTransactionResponseBody()
        TransactionInfo transactionInfo = processTransactionResponseBody.getTransactionInfo()

        then:
        null != transactionInfo.getTransactionAmount() && String.valueOf(amount) + ".00" == transactionInfo.getTransactionAmount()
    }
}
