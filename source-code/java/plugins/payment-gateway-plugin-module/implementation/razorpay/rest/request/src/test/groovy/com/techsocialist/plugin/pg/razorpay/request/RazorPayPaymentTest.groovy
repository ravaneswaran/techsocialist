package com.techsocialist.plugin.pg.razorpay.request

import com.techsocialist.plugin.marshaller.GoogleMarshallerPlugin
import com.techsocialist.plugin.marshaller.api.IMarshallerPlugin
import com.techsocialist.plugin.pg.api.request.IRazorPayEntity
import spock.lang.Specification

class RazorPayPaymentTest extends Specification {

    def "test RazorPayPayment instance"(){

        when:
        RazorPayPayment razorPayPayment = new RazorPayPayment()

        then:
        razorPayPayment instanceof IRazorPayEntity

    }

    def "test RazorPayPayment as json string"(){

        setup:
        RazorPayPayment razorPayPayment = new RazorPayPayment()
        IMarshallerPlugin marshallerPlugin = new GoogleMarshallerPlugin();
        long createdAt = new Date().getTime()

        when:
        razorPayPayment.setId("1111").setEntity(IRazorPayEntity.PAYMENT_ENTITY).setCreatedAt(createdAt)
        razorPayPayment.setAmount(1000).setCurrency("INR").setStatus("created").setMethod("card").setOrderId("222222").setDescription("test description")
        razorPayPayment.setAmountRefunded(0).setRefundStatus("refund yet to").setEmail("test@test.com").setContact("+91 1234567890")
        razorPayPayment.setRazorPayNotes(null).setFee(100).setTax(100).setErrorCode("").setErrorDescription("")

        String jsonString = marshallerPlugin.marshall(razorPayPayment)

        then:
         "{\"amount\":1000,\"currency\":\"INR\",\"status\":\"created\",\"method\":\"card\",\"order_id\":\"222222\",\"description\":\"test description\",\"amount_refunded\":0,\"refund_status\":\"refund yet to\",\"email\":\"test@test.com\",\"contact\":\"+91 1234567890\",\"fee\":100,\"tax\":100,\"error_code\":\"\",\"error_description\":\"\",\"id\":\"1111\",\"enitity\":\"Payment\",\"created_at\":"+createdAt+"}" == jsonString

    }

}
