package com.techsocialist.plugin.marshaller

import com.google.gson.annotations.SerializedName
import com.techsocialist.plugin.marshaller.api.IMarshallerPlugin
import spock.lang.Specification

class Test {

    @SerializedName("firstname")
    private String firstName

    @SerializedName("lastname")
    private String lastName

    String getFirstName() {
        return firstName
    }

    void setFirstName(String firstName) {
        this.firstName = firstName
    }

    String getLastName() {
        return lastName
    }

    void setLastName(String lastName) {
        this.lastName = lastName
    }
}

class GoogleMarshallerPluginTest extends Specification {

    def "test GoogleMarshallerPlugin instance"(){

        when:
        GoogleMarshallerPlugin googleMarshallerPlugin = new GoogleMarshallerPlugin()

        then:
        googleMarshallerPlugin instanceof IMarshallerPlugin
    }

    def "test GoogleMarshallerPlugin -> marshall()"(){

        setup:
        GoogleMarshallerPlugin googleMarshallerPlugin = new GoogleMarshallerPlugin()

        when:
        Test test = new Test();
        test.setFirstName("Ravaneswaran")
        test.setLastName("Chinnasamy")

        then:
        "{\"firstname\":\"Ravaneswaran\",\"lastname\":\"Chinnasamy\"}" == googleMarshallerPlugin.marshall(test)

    }

}


