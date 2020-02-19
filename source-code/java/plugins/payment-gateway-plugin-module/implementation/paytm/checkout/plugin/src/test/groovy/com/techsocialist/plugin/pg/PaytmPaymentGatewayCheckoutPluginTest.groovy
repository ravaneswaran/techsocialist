package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayCheckoutPlugin
import spock.lang.Specification

class PaytmPaymentGatewayCheckoutPluginTest extends Specification{

    def "test PaytmPaymentGatewayCheckoutPlugin instance"(){

        when:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        then:
        paymentGatewayCheckoutPlugin instanceof IPaymentGatewayCheckoutPlugin
    }

    def "test PaytmPaymentGatewayCheckoutPlugin -> renderCheckoutForm"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        String checkoutForm = paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        null != checkoutForm && checkoutForm.length() > 0
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when merchant id is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId(null).setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MERCHANT ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when merchant id is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MERCHANT ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when merchant key is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey(null).setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MERCHANT KEY cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when merchant key is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MERCHANT KEY cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when order id is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId(null).setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "ORDER ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when order id is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "ORDER ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when channel id is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId(null)
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CHANNEL ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when channel id is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CHANNEL ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when customer id is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId(null).setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CUSTOMER ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when customer id is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CUSTOMER ID cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when mobile number is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber(null).setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MOBILE NUMBER cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when mobile number is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MOBILE NUMBER cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when email is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail(null).setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "EMAIL cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when email is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "EMAIL cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when transaction amount is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount(null)
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "TRANSACTION AMOUNT cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when transaction amount is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "TRANSACTION AMOUNT cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when industry type is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType(null).setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "INDUSTRY TYPE cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when industry type is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("").setWebsite("https://olabolabola.com").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "INDUSTRY TYPE cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when website is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite(null).setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "WEBSITE cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when website is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("").setCallbackUrl("https://olabolabola.com/payment-gateway/response")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "WEBSITE cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when callback url is null"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl(null)
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CALLBACK URL cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin when callback url is empty"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setMerchantId("somemerchant").setMerchantKey("1111111111111111").setOrderId("222222").setChannelId("C11")
        paymentGatewayCheckoutPlugin.setCustomerId("1234").setMobileNumber("987654321").setEmail("test@test.com").setTransactionAmount("1000.00")
        paymentGatewayCheckoutPlugin.setIndustryType("Education").setWebsite("https://olabolabola.com").setCallbackUrl("")
        paymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CALLBACK URL cannot be null or empty..." == exception.getMessage()
    }

    def "test PaytmPaymentGatewayCheckoutPlugin staging url"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        String url = paymentGatewayCheckoutPlugin.getUrl(false)

        then:
        "https://securegw-stage.paytm.in/order/process" == url
    }

    def "test PaytmPaymentGatewayCheckoutPlugin production url"(){

        setup:
        PaytmPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PaytmPaymentGatewayCheckoutPlugin()

        when:
        String url = paymentGatewayCheckoutPlugin.getUrl(true)

        then:
        "https://securegw.paytm.in/order/process" == url
    }

}

