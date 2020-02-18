package com.techsocialist.plugin.pg.paytm.response

import com.techsocialist.plugin.pg.PaytmPaymentGatewayRestPlugin
import com.techsocialist.plugin.pg.api.IPaymentGatewayRestPlugin
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin

class ApplyPromoResponseTest extends AbstractPaytmResponseTest{

    def "test com.techsocialist.plugin.pg.paytm.response.ApplyPromoResponse as json string"(){

        setup:
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"
        String customerId = "CUSTOMER-ID-001"
        String promoCode = ""
        String transactionAmount = "1000"
        String payMethod = "NET_BANKING"
        String bankCode = "ALH"
        String cardNo = this.domesticMasterCreditCardOne
        String savedCardId = "12345"
        String vpa = ""
        String totalTransactionAmount = "1000"

        when:
        String jsonString = paymentGatewayRestPlugin.applyPromo(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, customerId, promoCode, transactionAmount, payMethod, bankCode, cardNo, savedCardId, vpa, totalTransactionAmount)

        then:
        null != jsonString
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ApplyPromoResponse as object"(){

        setup:
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"
        String customerId = "CUSTOMER-ID-001"
        String promoCode = ""
        String transactionAmount = "1000"
        String payMethod = "NET_BANKING"
        String bankCode = "ALH"
        String cardNo = this.domesticMasterCreditCardOne
        String savedCardId = "12345"
        String vpa = ""
        String totalTransactionAmount = "1000"

        when:
        String jsonString = paymentGatewayRestPlugin.applyPromo(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, customerId, promoCode, transactionAmount, payMethod, bankCode, cardNo, savedCardId, vpa, totalTransactionAmount)
        ApplyPromoResponse applyPromoResponse = unmarshallerPlugin.unmarshall(jsonString, ApplyPromoResponse.class)

        then:
        null != applyPromoResponse
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ApplyPromoResponse -> applyPromoResponseHead"(){

        setup:
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"
        String customerId = "CUSTOMER-ID-001"
        String promoCode = ""
        String transactionAmount = "1000"
        String payMethod = "NET_BANKING"
        String bankCode = "ALH"
        String cardNo = this.domesticMasterCreditCardOne
        String savedCardId = "12345"
        String vpa = ""
        String totalTransactionAmount = "1000"

        when:
        String jsonString = paymentGatewayRestPlugin.applyPromo(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, customerId, promoCode, transactionAmount, payMethod, bankCode, cardNo, savedCardId, vpa, totalTransactionAmount)
        ApplyPromoResponse applyPromoResponse = unmarshallerPlugin.unmarshall(jsonString, ApplyPromoResponse.class)

        then:
        null != applyPromoResponse.getApplyPromoResponseHead()
    }

    def "test com.techsocialist.plugin.pg.paytm.response.ApplyPromoResponse -> applyPromoResponseBody"(){

        setup:
        IUnmarshallerPlugin unmarshallerPlugin = new GoogleUnmarshallerPlugin()
        IPaymentGatewayRestPlugin paymentGatewayRestPlugin = new PaytmPaymentGatewayRestPlugin()
        String requestId = String.valueOf(new Date().getTime())
        String requestTimestamp = String.valueOf(new Date().getTime())
        String channelId = "WEB"
        String version = "v1"
        String tokenType = "CHECKSUM"
        String token = "CHECKSUM"
        String customerId = "CUSTOMER-ID-001"
        String promoCode = ""
        String transactionAmount = "1000"
        String payMethod = "NET_BANKING"
        String bankCode = "ALH"
        String cardNo = this.domesticMasterCreditCardOne
        String savedCardId = "12345"
        String vpa = ""
        String totalTransactionAmount = "1000"

        when:
        String jsonString = paymentGatewayRestPlugin.applyPromo(merchantId, merchantKey, version, requestId, requestTimestamp, channelId, tokenType, token, customerId, promoCode, transactionAmount, payMethod, bankCode, cardNo, savedCardId, vpa, totalTransactionAmount)
        ApplyPromoResponse applyPromoResponse = unmarshallerPlugin.unmarshall(jsonString, ApplyPromoResponse.class)

        then:
        null != applyPromoResponse.getApplyPromoResponseBody()
    }
}
