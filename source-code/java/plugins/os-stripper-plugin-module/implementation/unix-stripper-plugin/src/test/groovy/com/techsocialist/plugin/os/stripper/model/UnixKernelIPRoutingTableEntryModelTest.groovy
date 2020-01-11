package com.techsocialist.plugin.os.stripper.model

import spock.lang.Specification

class UnixKernelIPRoutingTableEntryModelTest extends Specification{

    def "testing setter and getter of destination in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setDestination("")
        then :
            "" == unixKernelIPRoutingTableEntry.getDestination()
    }

    def "testing setter and getter of gateway in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setGateway("")
        then :
            "" == unixKernelIPRoutingTableEntry.getGateway()
    }

    def "testing setter and getter of genmask in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setGenMask("")
        then :
            "" == unixKernelIPRoutingTableEntry.getGenMask()
    }

    def "testing setter and getter of flags in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setFlags("")
        then :
            "" == unixKernelIPRoutingTableEntry.getFlags()
    }

    def "testing setter and getter of mss in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setMSS("")
        then :
            "" == unixKernelIPRoutingTableEntry.getMSS()
    }

    def "testing setter and getter of window in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setWindow("")
        then :
            "" == unixKernelIPRoutingTableEntry.getWindow()
    }

    def "testing setter and getter of irtt in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setIRTT("")
        then :
            "" == unixKernelIPRoutingTableEntry.getIRTT()
    }

    def "testing setter and getter of iface in unix kernel ip routing table entry model"(){
        setup :
            def unixKernelIPRoutingTableEntry = new UnixKernelIPRoutingTableEntry()
        when :
            unixKernelIPRoutingTableEntry.setIFace("")
        then :
            "" == unixKernelIPRoutingTableEntry.getIFace()
    }
}
