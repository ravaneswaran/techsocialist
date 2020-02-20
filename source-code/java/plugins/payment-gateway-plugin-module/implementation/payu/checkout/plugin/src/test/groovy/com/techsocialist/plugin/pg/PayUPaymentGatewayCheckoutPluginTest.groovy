package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayCheckoutPlugin
import spock.lang.Specification

class PayUPaymentGatewayCheckoutPluginTest extends Specification {

    def "test PayUPaymentGatewayCheckoutPlugin instance"(){

        when:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        then:
        payUPaymentGatewayCheckoutPlugin instanceof IPaymentGatewayCheckoutPlugin

    }

    def "test PayUPaymentGatewayCheckoutPlugin -> renderStandardCheckout()"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("11111").setAccountId("222222").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        String checkout = payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(true)

        then:
        null != checkout

    }

    def "test PayUPaymentGatewayCheckoutPlugin when merchant id is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId(null).setAccountId("222222").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "MERCHANT ID cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when merchant id is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("").setAccountId("222222").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "MERCHANT ID cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when account id is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId(null).setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "ACCOUNT ID cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when account id is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "ACCOUNT ID cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when description is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription(null)
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "DESCRIPTION cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when description is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "DESCRIPTION cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when reference code is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode(null).setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "REFERENCE CODE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when reference code is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "REFERENCE CODE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when amount is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount(null).setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "AMOUNT cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when amount is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "AMOUNT cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when tax is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax(null).setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TAX cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when tax is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TAX cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when tax return base is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase(null)
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TAX RETURN BASE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when tax return base is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("100").setTaxReturnBase("")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TAX RETURN BASE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when currency is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency(null).setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "CURRENCY cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when currency is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "CURRENCY cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when signature is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature(null).setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "SIGNATURE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when signature is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "SIGNATURE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when test is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest(null)
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TEST cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when test is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TEST cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when buyer email is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail(null).setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "BUYER EMAIL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when buyer email is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "BUYER EMAIL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when response url is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl(null)
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "RESPONSE URL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when response url is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("http://www.test.com/confirmation")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "RESPONSE URL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when confirmation url is null"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("1111111").setAccountId("12345").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("555555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl(null)

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "CONFIRMATION URL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin when confirmation url is empty"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        payUPaymentGatewayCheckoutPlugin.setMerchantId("111111").setAccountId("123456").setDescription("test description")
        payUPaymentGatewayCheckoutPlugin.setReferenceCode("55555").setAmount("20000").setTax("100").setTaxReturnBase("16806")
        payUPaymentGatewayCheckoutPlugin.setCurrency("INR").setSignature("7ee7cf808ce6a39b17481c54f2c57acc").setTest("1")
        payUPaymentGatewayCheckoutPlugin.setBuyerEmail("test@test.com").setResponseUrl("http://www.test.com/response")
        payUPaymentGatewayCheckoutPlugin.setConfirmationUrl("")

        payUPaymentGatewayCheckoutPlugin.renderStandardCheckout(true)

        then:
        Exception exception = thrown()
        "CONFIRMATION URL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayUPaymentGatewayCheckoutPlugin -> getUrl()"(){

        setup:
        PayUPaymentGatewayCheckoutPlugin payUPaymentGatewayCheckoutPlugin = new PayUPaymentGatewayCheckoutPlugin()

        when:
        String stagingUrl = payUPaymentGatewayCheckoutPlugin.getUrl(false)

        then:
        "https://sandbox.checkout.payulatam.com/ppp-web-gateway-payu/" == stagingUrl

    }

}
