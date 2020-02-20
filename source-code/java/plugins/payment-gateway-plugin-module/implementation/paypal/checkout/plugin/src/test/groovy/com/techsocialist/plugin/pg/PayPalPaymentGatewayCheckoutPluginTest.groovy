package com.techsocialist.plugin.pg

import com.techsocialist.plugin.pg.api.IPaymentGatewayCheckoutPlugin
import spock.lang.Specification

class PayPalPaymentGatewayCheckoutPluginTest extends Specification {

    def "test PayPalPaymentGatewayCheckoutPlugin instance"(){

        when:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        then:
        paymentGatewayCheckoutPlugin instanceof IPaymentGatewayCheckoutPlugin

    }

    def "test PayPalPaymentGatewayCheckoutPlugin -> renderStandardCheckout()"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        String checkout = paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        null != checkout && checkout.length() > 0

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when currency is null"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency(null).setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "CURRENCY cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when currency is empty"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "CURRENCY cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when commit is null"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit(null).setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "COMMIT cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when commit is empty"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "COMMIT cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when locale is null"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale(null).setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "LOCALE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when locale is empty"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "LOCALE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when total is null"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal(null)
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TOTAL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when total is empty"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "TOTAL cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when style color is null"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor(null).setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "STYLE COLOR cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when style color is empty"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("").setStyleShape("pill").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "STYLE COLOR cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when style shape is null"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape(null).setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "STYLE SHAPE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when style shape is empty"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("").setStyleSize("small")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "STYLE SHAPE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when style size is null"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize(null)
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "STYLE SIZE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when style size is empty"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("")
        paymentGatewayCheckoutPlugin.renderStandardCheckout(false)

        then:
        Exception exception = thrown()
        "STYLE SIZE cannot be null or empty..." == exception.getMessage()

    }

    def "test PayPalPaymentGatewayCheckoutPlugin when renderStandardCheckout() referring production"(){

        setup:
        PayPalPaymentGatewayCheckoutPlugin paymentGatewayCheckoutPlugin = new PayPalPaymentGatewayCheckoutPlugin()

        when:
        paymentGatewayCheckoutPlugin.setCurrency("INR").setCommit("true").setLocale("en_US").setTotal("100.00")
        paymentGatewayCheckoutPlugin.setStyleColor("black").setStyleShape("pill").setStyleSize("small")
        String checkout = paymentGatewayCheckoutPlugin.renderStandardCheckout(true)

        then:
        null != checkout

    }
}
