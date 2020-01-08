package com.techsocialist.plugin.unix.stripper.model.impl

import spock.lang.Specification

class UnixSystemPropertyModelTest extends Specification{

    def "testing setter and getter of key in unix system property model"(){
        setup :
            def unixSystemProperty = new UnixSystemProperty()
        when :
            unixSystemProperty.setKey("")
        then :
            "" == unixSystemProperty.getKey()
    }

    def "testing setter and getter of value in unix system property model"(){
        setup :
            def unixSystemProperty = new UnixSystemProperty()
        when :
        unixSystemProperty.setValue("")
        then :
            "" == unixSystemProperty.getValue()
    }
}
