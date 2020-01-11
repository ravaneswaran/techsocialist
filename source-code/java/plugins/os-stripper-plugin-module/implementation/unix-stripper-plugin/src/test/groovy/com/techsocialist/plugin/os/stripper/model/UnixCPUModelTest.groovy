package com.techsocialist.plugin.os.stripper.model

import spock.lang.Specification

class UnixCPUModelTest extends Specification {

    def "testing setter and getter of cpu detail"() {
        setup:
        def unixCPU = new UnixCPU()
        when:
        unixCPU.setCPUDetail("test")
        then:
        "test" == unixCPU.getCPUDetail()
    }
}
