package com.techsocialist.plugin.pg.razorpay.request

import com.techsocialist.plugin.pg.api.request.IRazorPayEntity
import com.techsocialist.plugin.pg.razorpay.request.innerstruct.RazorPayNote
import com.techsocialist.plugin.unmarshaller.GoogleUnmarshallerPlugin
import com.techsocialist.plugin.unmarshaller.api.IUnmarshallerPlugin
import spock.lang.Specification

class RazorPayCustomerTest extends Specification {

    def "test RazorPayCustomer customer instance"(){

        when:
        RazorPayCustomer razorPayCustomer = new RazorPayCustomer()

        then:
        razorPayCustomer instanceof IRazorPayEntity

    }

    def "test RazorPayCustomer as json"(){
        setup:
        RazorPayCustomer razorPayCustomer = new RazorPayCustomer()

        when:
        RazorPayNote note = new RazorPayNote()
        note.setLandmark("test landmark").setLocation("test location")

        razorPayCustomer.setName("Ravaneswaran Chinnasamy").setEmail("test@test.com").setId("123456789").setContact("+91 9897654567")
        razorPayCustomer.setEntity(IRazorPayEntity.CUSTOMER_ENTITY).setCreatedAt(new Date().getTime()).setGstin("222222")
        razorPayCustomer.setNote(note)

        then:
        null != razorPayCustomer
    }
}
