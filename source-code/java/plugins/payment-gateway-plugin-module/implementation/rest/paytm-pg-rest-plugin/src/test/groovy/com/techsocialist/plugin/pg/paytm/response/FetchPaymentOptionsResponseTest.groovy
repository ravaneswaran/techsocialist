package com.techsocialist.plugin.pg.paytm.response


import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.FetchPaymentOptionsResponseBody
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.*
import com.techsocialist.plugin.pg.paytm.response.head.FetchPaymentOptionsResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class FetchPaymentOptionsResponseTest extends AbstractPaytmResponseTest{

    def "test fetch payment options"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)

        then:
        null != jsonResponse
    }

    def "test fetch payment options is not ok"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions("some-merchant-id", merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        ResultInfo resultInfo = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody().getResultInfo()

        then:
        false == fetchPaymentOptionsResponse.ok() && "S" != resultInfo.getResultStatus() && 0 < Integer.parseInt(resultInfo.getResultCode()) && "Success" != resultInfo.getResultMessage()
    }

    def "test fetch payment options is ok"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)

        then:
        true == fetchPaymentOptionsResponse.ok()
    }

    def "test fetch payment options response head"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseHead fetchPaymentOptionsResponseHead = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseHead();

        then:
        null == fetchPaymentOptionsResponseHead.getRequestId() && null != fetchPaymentOptionsResponseHead.getResponseTimestamp() && null != fetchPaymentOptionsResponseHead.getVersion()
    }

    def "test fetch payment options response head for values"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseHead fetchPaymentOptionsResponseHead = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseHead()

        then:
        null == fetchPaymentOptionsResponseHead.getRequestId() && fetchPaymentOptionsResponseHead.getResponseTimestamp().length() > 0 && "v1" == fetchPaymentOptionsResponseHead.getVersion()
    }

    def "test fetch payment options response body"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        null != fetchPaymentOptionsResponseBody
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantDetails"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantDetails merchantDetails = fetchPaymentOptionsResponseBody.getMerchantDetails()

        then:
        null == merchantDetails.getMcc() && null == merchantDetails.getMerchantVpa() && "Ravaneswaran Chinnasamy" == merchantDetails.getMerchantName() && null == merchantDetails.getMerchantLogo()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()

        then:
        0 < merchantPayOption.getPaymentModes().size() && 0 == merchantPayOption.getSavedInstruments().size() && null == merchantPayOption.getUserProfileSarvatra() && null == merchantPayOption.getActiveSubscriptions()
    }

    def "test FetchPaymentOptionsResponseBody -> AddMoneyPayOption"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        AddMoneyPayOption addMoneyPayOption = fetchPaymentOptionsResponseBody.getAddMoneyPayOption()

        then:
        null == addMoneyPayOption.getPaymentModes() && null == addMoneyPayOption.getSavedInstruments() && null == addMoneyPayOption.getUserProfileSarvatra() && null == addMoneyPayOption.getActiveSubscriptions()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantLimitInfo"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantLimitInfo merchantLimitInfo = fetchPaymentOptionsResponseBody.getMerchantLimitInfo()

        then:
        0 < merchantLimitInfo.getMerchantRemainingLimits().size() && null == merchantLimitInfo.getExcludePayModes() && "limit is breached for this pay-mode" == merchantLimitInfo.getMessage()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantLimitInfo -> MerchantRemainingLimits"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantLimitInfo merchantLimitInfo = fetchPaymentOptionsResponseBody.getMerchantLimitInfo()
        List<MerchantRemainingLimit> merchantRemainingLimits = merchantLimitInfo.getMerchantRemainingLimits()

        then:
        0 < merchantRemainingLimits.size()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantLimitInfo -> MerchantRemainingLimit"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantLimitInfo merchantLimitInfo = fetchPaymentOptionsResponseBody.getMerchantLimitInfo()
        List<MerchantRemainingLimit> merchantRemainingLimits = merchantLimitInfo.getMerchantRemainingLimits()
        MerchantRemainingLimit merchantRemainingLimit = merchantRemainingLimits.get(0)

        then:
        "DAILY" == merchantRemainingLimit.getLimitType() && "100000.00" == merchantRemainingLimit.getAmount()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> PaymentModeList"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<PaymentMode> paymentModes = merchantPayOption.getPaymentModes()

        then:
        paymentModes.size() > 0
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> PaymentMode"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<PaymentMode> paymentModes = merchantPayOption.getPaymentModes()
        PaymentMode paymentMode = paymentModes.get(0)

        then:
        "Paytm Balance" == paymentMode.getDisplayName() && null == paymentMode.getFeeAmount() && null == paymentMode.getTaxAmount() && null == paymentMode.getTotalTransactionAmount() && null == paymentMode.getPriority() && false == paymentMode.isOnBoarding() && "BALANCE" == paymentMode.getMode() && false == paymentMode.isHybridDisabled()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> IsDisabled"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<PaymentMode> paymentModes = merchantPayOption.getPaymentModes()
        PaymentMode paymentMode = paymentModes.get(0)
        IsDisabled isDisabled = paymentMode.getIsDisabled()

        then:
        "true" == isDisabled.getStatus() && "Merchant is not accepting payment thru BALANCE" == isDisabled.getMessage() && "false" == isDisabled.getUserAccountExist() && "false" == isDisabled.getMerchantAccept()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> PaymentMode -> PayChannelOptionList"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<PaymentMode> paymentModes = merchantPayOption.getPaymentModes()
        PaymentMode paymentMode = paymentModes.get(0)
        List<PayChannelOption> payChannelOptions = paymentMode.getPayChannelOptions()

        then:
        payChannelOptions.size() > 0
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> PaymentMode -> PayChannelOption"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<PaymentMode> paymentModes = merchantPayOption.getPaymentModes()
        PaymentMode paymentMode = paymentModes.get(0)
        List<PayChannelOption> payChannelOptions = paymentMode.getPayChannelOptions()
        PayChannelOption payChannelOption = payChannelOptions.get(0)

        then:
        null != payChannelOption.getIsDisabled() && null != payChannelOption.getHasLowSuccess() && null == payChannelOption.getIconUrl() && null == payChannelOption.getBalanceInfo() && false == payChannelOption.isHybridDisabled()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> PaymentMode -> PayChannelOption -> HasLowSuccess"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<PaymentMode> paymentModes = merchantPayOption.getPaymentModes()
        PaymentMode paymentMode = paymentModes.get(0)
        List<PayChannelOption> payChannelOptions = paymentMode.getPayChannelOptions()
        PayChannelOption payChannelOption = payChannelOptions.get(0)
        HasLowSuccess hasLowSuccess = payChannelOption.getHasLowSuccess()

        then:
        "false" == hasLowSuccess.getStatus() && "" == hasLowSuccess.getMessage()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> SavedInstruments"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<SavedInstrument> savedInstruments = merchantPayOption.getSavedInstruments()


        then:
        0 == savedInstruments.size()
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> UserProfileSarvatra"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        UserProfileSarvatra userProfileSarvatra = merchantPayOption.getUserProfileSarvatra()

        then:
        null == userProfileSarvatra
    }

    def "test FetchPaymentOptionsResponseBody -> MerchantPayOption -> ActiveSubscriptionList"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()
        MerchantPayOption merchantPayOption = fetchPaymentOptionsResponseBody.getMerchantPayOption()
        List<ActiveSubscription> activeSubscriptions = merchantPayOption.getActiveSubscriptions()

        then:
        null == activeSubscriptions
    }

    def "test isWalletOnly of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        false == fetchPaymentOptionsResponseBody.isWalletOnly()
    }

    def "test zeroCodeEmi of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        false == fetchPaymentOptionsResponseBody.isZeroCostEmi()
    }

    def "test pcfEnabled of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        false == fetchPaymentOptionsResponseBody.isPcfEnabled()
    }

    def "test nativeJsonRequestSupported of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        false == fetchPaymentOptionsResponseBody.isNativeJsonRequestSupported()
    }

    def "test activeMerchant of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        true == fetchPaymentOptionsResponseBody.isActiveMerchant()
    }

    def "test oneClickMaxAmount of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        "2000" == fetchPaymentOptionsResponseBody.getOneClickMaxAmount()
    }

    def "test onTheFlyKYCRequired of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        false == fetchPaymentOptionsResponseBody.isOnTheFlyKYCRequired()
    }

    def "test paymentFlow of FetchPaymentOptionsResponseBody"(){
        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        def customerId = String.format("CUSTOMER-ID-%s", new Date().getTime())
        def orderId = String.format("ORDER-ID-%s", new Date().getTime())
        def amount = 1000
        def currency = "INR"
        def websiteName = "WEBSTAGING"
        def callbackUrl = "http://techsocialist.com/smart-video/payment"
        String jsonResponse = paymentGatewayRestPlugin.initiateTransaction(merchantId, merchantKey, customerId, orderId, amount, currency, websiteName, callbackUrl)
        IUnmarshallerPluginAPI iUnmarshallerPluginAPI = new GoogleUnmarshallerPlugin()
        InitiateTransactionResponse initiateTransactionResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, InitiateTransactionResponse.class)

        when:
        jsonResponse = paymentGatewayRestPlugin.fetchPaymentOptions(merchantId, merchantKey, initiateTransactionResponse.getInitiateTransactionResponseBody().getTransactionToken(), orderId)
        FetchPaymentOptionsResponse fetchPaymentOptionsResponse = iUnmarshallerPluginAPI.unmarshall(jsonResponse, FetchPaymentOptionsResponse.class)
        FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody = fetchPaymentOptionsResponse.getFetchPaymentOptionsResponseBody()

        then:
        "NONE" == fetchPaymentOptionsResponseBody.getPaymentFlow()
    }
}
