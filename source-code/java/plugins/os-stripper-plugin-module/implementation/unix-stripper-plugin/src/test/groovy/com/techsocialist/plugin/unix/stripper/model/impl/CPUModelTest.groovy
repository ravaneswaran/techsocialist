package com.techsocialist.plugin.unix.stripper.model.impl

import spock.lang.Specification

class CPUModelTest extends Specification{

    def "testing setter and getter of cpu detail"(){
        setup :
            def unixCPU = new UnixCPU()
        when :
            unixCPU.setCPUDetail("test")
        then :
            "test" == unixCPU.getCPUDetail()
    }
}
