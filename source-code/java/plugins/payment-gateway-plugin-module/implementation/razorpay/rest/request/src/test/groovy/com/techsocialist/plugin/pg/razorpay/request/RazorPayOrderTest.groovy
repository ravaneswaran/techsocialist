package com.techsocialist.plugin.pg.razorpay.request

import com.techsocialist.plugin.marshaller.GoogleMarshallerPlugin
import com.techsocialist.plugin.marshaller.api.IMarshallerPlugin
import com.techsocialist.plugin.pg.api.request.IRazorPayEntity
import spock.lang.Specification

class RazorPayOrderTest extends Specification {

    def "test RazorPayOrder instance"(){

        when:
        RazorPayOrder razorPayOrder = new RazorPayOrder()

        then:
        razorPayOrder instanceof IRazorPayEntity

    }

    def "test RazorPayOrder as json"(){

        setup:
        RazorPayOrder razorPayOrder = new RazorPayOrder()
        IMarshallerPlugin marshallerPlugin = new GoogleMarshallerPlugin()

        when:
        long createdAt = new Date().getTime()
        razorPayOrder.setId("12345").setEntity(IRazorPayEntity.ORDER_ENTITY).setCurrency("INR").setAmount(10000).setAmountPaid(0).setAmountDue(10000)
        razorPayOrder.setAttempts(0).setReceipt("receipt_001").setStatus("created").setCreatedAt(createdAt)
        razorPayOrder.setRazorPayNotes(null)

        String jsonString = marshallerPlugin.marshall(razorPayOrder)

        then:
        "{\"amount\":10000,\"amount_paid\":0,\"amount_due\":10000,\"currency\":\"INR\",\"receipt\":\"receipt_001\",\"status\":\"created\",\"attempts\":0,\"id\":\"12345\",\"enitity\":\"Order\",\"created_at\":"+createdAt+"}" == jsonString
    }
}
