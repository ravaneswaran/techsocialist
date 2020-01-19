package com.techsocialist.plugin.unmarshaller

import com.techsocialist.plugin.unmarshaller.model.Person
import spock.lang.Specification

class JAXBUnmarshallerPluginTest extends Specification{

    def "test jaxb unmarshaller plugin"(){
        setup:
        String xmlString = "<person><name>Test</name><age>21</age><gender>Male</gender></person>"
        def jaxbUnmarshallerPlugin = new JAXBUnmarshallerPlugin();

        when:
        Person person = jaxbUnmarshallerPlugin.unmarshall(xmlString, Person.class)

        then:
        person != null && "Test" == person.getName() && 21 == person.getAge() && "Male" == person.getGender()
    }
}
