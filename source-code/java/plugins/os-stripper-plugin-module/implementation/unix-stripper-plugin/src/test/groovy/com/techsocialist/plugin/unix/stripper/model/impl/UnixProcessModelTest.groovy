package com.techsocialist.plugin.unix.stripper.model.impl

import spock.lang.Specification

class UnixProcessModelTest extends Specification{

    def "testing setter and getter of user in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setUser("")
        then :
            "" == unixProcess.getUser()
    }

    def "testing setter and getter of pid in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setPID("")
        then :
            "" == unixProcess.getPID()
    }

    def "testing setter and getter of cpu percentage in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setCPUPercentage("")
        then :
            "" == unixProcess.getCPUPercentage()
    }

    def "testing setter and getter of memory percentage in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setMemoryPercentage("")
        then :
            "" == unixProcess.getMemoryPercentage()
    }

    def "testing setter and getter of vsz in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setVSZ("")
        then :
            "" == unixProcess.getVSZ()
    }

    def "testing setter and getter of rss in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setRSS("")
        then :
            "" == unixProcess.getRSS()
    }

    def "testing setter and getter of stat in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setSTAT("")
        then :
            "" == unixProcess.getSTAT()
    }

    def "testing setter and getter of start in unix process model"(){
        setup :
            def unixProcess = new UnixProcess()
        when :
            unixProcess.setStart("")
        then :
            "" == unixProcess.getStart()
    }

    def "testing setter and getter of tty in unix process model"(){
        setup :
        def unixProcess = new UnixProcess()
        when :
        unixProcess.setTTY("")
        then :
        "" == unixProcess.getTTY()
    }

    def "testing setter and getter of time in unix process model"(){
        setup :
        def unixProcess = new UnixProcess()
        when :
        unixProcess.setTime("")
        then :
        "" == unixProcess.getTime()
    }

    def "testing setter and getter of command in unix process model"(){
        setup :
        def unixProcess = new UnixProcess()
        when :
        unixProcess.setCommand("")
        then :
        "" == unixProcess.getCommand()
    }
}
