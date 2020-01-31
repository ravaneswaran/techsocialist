package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.FetchBinDetailsResponseBody
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.BinDetail
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.HasLowSuccess
import com.techsocialist.plugin.pg.paytm.response.head.FetchBinDetailsResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class FetchBinDetailsResponseTest extends AbstractPaytmResponseTest {

    def "test FetchBinDetailsResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)

        then:
        null != jsonResponse

    }

    def "test FetchBinDetailsResponse as object"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)

        then:
        null != fetchBinDetailsResponse

    }

    def "test FetchBinDetailsResponse -> ok()"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)

        then:
        true == fetchBinDetailsResponse.ok()

    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseHead"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseHead fetchBinDetailsResponseHead = fetchBinDetailsResponse.getFetchBinDetailsResponseHead()

        then:
        null != fetchBinDetailsResponseHead

    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseHead -> requestId"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseHead fetchBinDetailsResponseHead = fetchBinDetailsResponse.getFetchBinDetailsResponseHead()

        then:
        null == fetchBinDetailsResponseHead.getRequestId()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseHead -> responseTimestamp"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseHead fetchBinDetailsResponseHead = fetchBinDetailsResponse.getFetchBinDetailsResponseHead()

        then:
        null != fetchBinDetailsResponseHead.getResponseTimestamp()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseHead -> version"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseHead fetchBinDetailsResponseHead = fetchBinDetailsResponse.getFetchBinDetailsResponseHead()

        then:
        "v1" ==  fetchBinDetailsResponseHead.getVersion()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        null != fetchBinDetailsResponseBody
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> isEmiAvailable"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        false == fetchBinDetailsResponseBody.isEmiAvailable()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> iconUrl"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        null != fetchBinDetailsResponseBody.getIconUrl()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> errorMessage"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        null != fetchBinDetailsResponseBody.getErrorMessage()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> isHybridDisabled"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        false == fetchBinDetailsResponseBody.isHybridDisabled()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> oneClickSupported"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        false == fetchBinDetailsResponseBody.isOneClickSupported()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> oneClickMaxAmount"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        "2000" == fetchBinDetailsResponseBody.getOneClickMaxAmount()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> authModes"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        null != fetchBinDetailsResponseBody.getAuthModes() && fetchBinDetailsResponseBody.getAuthModes().size() > 0 && "otp" == fetchBinDetailsResponseBody.getAuthModes().get(0)
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> hasLowSuccessRate"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()

        then:
        null != fetchBinDetailsResponseBody.getHasLowSuccessRate()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> HasLowSuccess -> status"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        HasLowSuccess hasLowSuccess = fetchBinDetailsResponseBody.getHasLowSuccessRate()

        then:
        "false" == hasLowSuccess.getStatus()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> HasLowSuccess -> msg"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        HasLowSuccess hasLowSuccess = fetchBinDetailsResponseBody.getHasLowSuccessRate()

        then:
        "" == hasLowSuccess.getMessage()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> binDetail"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> bin"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        "123456" == binDetail.getBin()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> issuingBank"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getIssuingBank()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> issuingBankCode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getIssuingBankCode()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> paymentMode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getPaymentMode()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> channelName"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getChannelName()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> channelCode"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getChannelCode()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> cnMin"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getCnMin()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> cnMax"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getCnMax()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> cvvR"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getCvvR()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> cvvL"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getCvvL()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> expR"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        null != binDetail.getExpR()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> isActive"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        "true" == binDetail.getIsActive()
    }

    def "test FetchBinDetailsResponse -> FetchBinDetailsResponseBody -> BinDetail -> isIndian"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        def bin = "123456"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPlugin iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchBinDetails(merchantId, merchantKey, orderId, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), bin)
        FetchBinDetailsResponse fetchBinDetailsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchBinDetailsResponse.class)
        FetchBinDetailsResponseBody fetchBinDetailsResponseBody = fetchBinDetailsResponse.getFetchBinDetailsResponseBody()
        BinDetail binDetail = fetchBinDetailsResponseBody.getBinDetail()

        then:
        "true" == binDetail.getIsIndian()
    }
}
