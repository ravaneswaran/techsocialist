package com.techsocialist.plugin.pg.razorpay.request

import com.techsocialist.plugin.marshaller.GoogleMarshallerPlugin
import com.techsocialist.plugin.marshaller.api.IMarshallerPlugin
import com.techsocialist.plugin.pg.api.request.IRazorPayEntity
import spock.lang.Specification

class RazorPaySettlementTest extends Specification {

    def "test RazorPaySettlement instance"(){

        when:
        RazorPaySettlement razorPaySettlement = new RazorPaySettlement()

        then:
        razorPaySettlement instanceof IRazorPayEntity

    }

    def "test RazorPaySettlement as json string"(){

        setup:
        RazorPaySettlement razorPaySettlement = new RazorPaySettlement()
        IMarshallerPlugin marshallerPlugin = new GoogleMarshallerPlugin()
        long createdAt = new Date().getTime()

        when:
        razorPaySettlement.setId("111111").setEntity(IRazorPayEntity.SETTLEMENT_ENTITY).setCreatedAt(createdAt)
        razorPaySettlement.setAmount(1000).setStauts("status").setFees(123).setTax(234).setUtr("utr")

        String jsonString = marshallerPlugin.marshall(razorPaySettlement)

        then:
        "{\"amount\":1000,\"status\":\"status\",\"fees\":123,\"tax\":234,\"utr\":\"utr\",\"id\":\"111111\",\"enitity\":\"settlement\",\"created_at\":"+createdAt+"}" == jsonString
    }
}
