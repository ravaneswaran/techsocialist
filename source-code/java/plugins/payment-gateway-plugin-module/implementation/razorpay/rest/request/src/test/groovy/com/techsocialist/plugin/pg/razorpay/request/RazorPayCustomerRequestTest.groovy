package com.techsocialist.plugin.pg.razorpay.request

import com.techsocialist.plugin.marshaller.GoogleMarshallerPlugin
import com.techsocialist.plugin.marshaller.api.IMarshallerPlugin
import com.techsocialist.plugin.pg.api.request.IRazorPayRequest
import spock.lang.Specification

class RazorPayCustomerRequestTest extends Specification{

    def "test CustomerRequest instance"(){

        when:
        RazorPayCustomerRequest razorPayCustomerRequest = new RazorPayCustomerRequest()

        then:
        razorPayCustomerRequest instanceof IRazorPayRequest
    }

    def "test CustomerRequest as json string"(){

        setup:
        RazorPayCustomerRequest razorPayCustomerRequest = new RazorPayCustomerRequest()
        IMarshallerPlugin marshallerPlugin = new GoogleMarshallerPlugin()

        when:
        razorPayCustomerRequest.setName("Ravaneswaran Chinnasamy").setEmail("test@test.com").setContact("+91 989232322333").setFailExisting("0")
        String jsonString = marshallerPlugin.marshall(razorPayCustomerRequest)

        then:
        "{\"name\":\"Ravaneswaran Chinnasamy\",\"email\":\"test@test.com\",\"contact\":\"+91 989232322333\",\"fail_existing\":\"0\"}" == jsonString
    }

}
