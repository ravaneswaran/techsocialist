package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.AbstractPaytmPaymentGatewayTest
import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.paytm.response.body.FetchPaymentOptionsResponseBody
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.AddMoneyPayOption
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.MerchantDetails
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.MerchantLimitInfo
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.MerchantPayOption
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.MerchantRemainingLimit
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.ResultInfo
import com.techsocialist.plugin.pg.paytm.response.head.FetchPaymentOptionsResponseHead
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPluginAPI

class FetchPaymentOptionsResponseTest extends AbstractPaytmPaymentGatewayTest{

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

    def "test merchant details of fetch payment options response body"(){
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

    def "test merchant pay option of fetch payment options response body"(){
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

    def "test add money pay option of fetch payment options response body"(){
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

    def "test merchant limit info of fetch payment options response body"(){
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

    def "test merchant remaining limits info of merchant limit info of fetch payment options response body"(){
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


}
