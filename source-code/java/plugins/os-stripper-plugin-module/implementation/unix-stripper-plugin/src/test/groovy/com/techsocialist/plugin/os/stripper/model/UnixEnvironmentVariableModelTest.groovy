package com.techsocialist.plugin.os.stripper.model

import spock.lang.Specification

class UnixEnvironmentVariableModelTest extends Specification{

    def "testing setter and getter of key in unix environment model"(){
        setup :
            def unixEnvironmentVariable = new UnixEnvironmentVariable()
        when :
            unixEnvironmentVariable.setKey("")
        then :
            "" == unixEnvironmentVariable.getKey()
    }

    def "testing setter and getter of value in unix environment model"(){
        setup :
            def unixEnvironmentVariable = new UnixEnvironmentVariable()
        when :
            unixEnvironmentVariable.setValue("")
        then :
            "" == unixEnvironmentVariable.getValue()
    }
}
