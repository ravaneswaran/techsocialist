package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayCheckoutPlugin
import spock.lang.Specification

class RazorPayPaymentGatewayCheckoutPluginTest extends Specification{

    def "test RazorPayPaymentGatewayCheckoutPlugin instance"(){

        when:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        then:
        razorPayPaymentGatewayCheckoutPlugin instanceof IPaymentGatewayCheckoutPlugin
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin -> renderStandardCheckoutForm()"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("12345").setTransactionAmount("50000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("2222222222").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        String checkoutForm = razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        null != checkoutForm && checkoutForm.length() > 0
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when merchant id is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId(null).setTransactionAmount("50000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("2222222222").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MERCHANT ID cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when merchant id is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("").setTransactionAmount("50000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("2222222222").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "MERCHANT ID cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when transaction amount is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount(null).setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("2222222222").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "TRANSACTION AMOUNT cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when transaction amount is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("2222222222").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "TRANSACTION AMOUNT cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when current is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency(null)
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("2222222222").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CURRENCY cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when current is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("2222222222").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CURRENCY cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when order id is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId(null).setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "ORDER ID cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when order id is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "ORDER ID cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when button text is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("23456").setButtonText(null).setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        String checkoutForm = razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        null != checkoutForm
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when button text is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("23456").setButtonText("").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        String checkoutForm = razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        null != checkoutForm
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when name is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName(null)
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "NAME cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when name is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "NAME cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when image url is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl(null).setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "IMAGE URL cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when image url is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "IMAGE URL cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when prefill name is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName(null)
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "PREFILL NAME cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when prefill name is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "PREFILL NAME cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when prefill email is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail(null).setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "PREFILL EMAIL cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when prefill email is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "PREFILL EMAIL cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when prefill contact is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact(null)
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "PREFILL CONTACT cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when prefill contact is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "PREFILL CONTACT cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when callback url is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl(null)

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CALLBACK URL cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when callback url is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("Test Description").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("")

        razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        Exception exception = thrown()
        "CALLBACK URL cannot be null or empty..." == exception.getMessage()
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when description is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription(null).setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("#fdfd88f").setCallbackUrl("http://localhost:8080/olabolabola")

        String checkoutForm = razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        null != checkoutForm
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when theme color is null"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor(null).setCallbackUrl("http://localhost:8080/olabolabola")

        String checkoutForm = razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        null != checkoutForm
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin when theme color is empty"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("").setCallbackUrl("http://localhost:8080/olabolabola")

        String checkoutForm = razorPayPaymentGatewayCheckoutPlugin.renderStandardCheckoutForm(false)

        then:
        null != checkoutForm
    }

    def "test RazorPayPaymentGatewayCheckoutPlugin ->  renderManualCheckoutForm()"(){

        setup:
        RazorPayPaymentGatewayCheckoutPlugin razorPayPaymentGatewayCheckoutPlugin = new RazorPayPaymentGatewayCheckoutPlugin()

        when:
        razorPayPaymentGatewayCheckoutPlugin.setMerchantId("11111").setTransactionAmount("5000").setCurrency("INR")
        razorPayPaymentGatewayCheckoutPlugin.setOrderId("45678").setButtonText("Test Text").setName("Tech Socialist")
        razorPayPaymentGatewayCheckoutPlugin.setDescription("").setImageUrl("http://localhost:8080/image-url").setPrefillName("Ravaneswaran Chinnasamy")
        razorPayPaymentGatewayCheckoutPlugin.setPrefillEmail("ravaneswaran@gmail.com").setPrefillContact("987654321")
        razorPayPaymentGatewayCheckoutPlugin.setThemeColor("").setCallbackUrl("http://localhost:8080/olabolabola")

        String checkoutForm = razorPayPaymentGatewayCheckoutPlugin.renderManualCheckoutForm(false)

        then:
        System.out.println(checkoutForm)
        null != checkoutForm
    }
}