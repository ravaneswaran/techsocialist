package com.techsocialist.plugin.unmarshaller

import com.techsocialist.plugin.unmarshaller.model.Person
import spock.lang.Specification

class GoogleUnmarshallerPluginTest extends Specification{

    def "test google un marshaller plugin"(){
        setup:
        String jsonString = "{'name':'Test', 'age':21, 'gender':'Male'}"
        GoogleUnmarshallerPlugin googleUnmarshallerPlugin = new GoogleUnmarshallerPlugin()

        when:
        Person person = googleUnmarshallerPlugin.unmarshall(jsonString, Person.class)

        then:
        null != person && "Test" == person.getName() && 21 == person.getAge() && "Male" == person.getGender()

    }

}
