package com.techsocialist.plugin.pg.razorpay.request

import com.techsocialist.plugin.marshaller.GoogleMarshallerPlugin
import com.techsocialist.plugin.marshaller.api.IMarshallerPlugin
import com.techsocialist.plugin.pg.api.request.IRazorPayEntity
import com.techsocialist.plugin.pg.razorpay.request.innerstruct.RazorPayNote
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
        IMarshallerPlugin marshallerPlugin = new GoogleMarshallerPlugin();

        when:
        RazorPayNote note = new RazorPayNote()
        note.setLandmark("test landmark").setLocation("test location")
        long createdAt = new Date().getTime();

        razorPayCustomer.setId("123456789").setEntity(IRazorPayEntity.CUSTOMER_ENTITY).setCreatedAt(createdAt)
        razorPayCustomer.setName("Ravaneswaran Chinnasamy").setEmail("test@test.com").setContact("+91 9897654567")
        razorPayCustomer.setGstin("222222")
        razorPayCustomer.setNote(note)

        String jsonString = marshallerPlugin.marshall(razorPayCustomer);

        then:
        "{\"name\":\"Ravaneswaran Chinnasamy\",\"email\":\"test@test.com\",\"contact\":\"+91 9897654567\",\"gstin\":\"222222\",\"notes\":{\"landmark\":\"test landmark\",\"location\":\"test location\"},\"id\":\"123456789\",\"enitity\":\"customer\",\"created_at\":"+createdAt+"}" == jsonString
    }
}
