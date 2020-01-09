package com.techsocialist.plugin.linux.command.exec


import com.techsocialist.plugin.os.command.exec.util.OSCommandExecUtil
import spock.lang.Specification

class LinuxCommandExecServiceTest extends Specification{

    def "executing the command ls -la through the OSCommandExecUtil.getOSCommandExecService"(){
        setup :
            def commandExecService = OSCommandExecUtil.getOSCommandExecService(LinuxCommandExecService.class.getName())
            def command = "ls -la"
        when :
            commandExecService.executeCommand(command)
        then :
            null != commandExecService.getOutput()
    }

    def "executing the command ls -la"(){
        setup :
            def linuxCommandExecService = new LinuxCommandExecService()
            def command = "ls -la"
        when :
            linuxCommandExecService.executeCommand(command)
        then :
            null != linuxCommandExecService.getOutput()

    }

    def "executing an invalid command"(){
        setup :
            def linuxCommandExecService = new LinuxCommandExecService()
            def command = "blah"
        when :
            linuxCommandExecService.executeCommand(command)
        then :
            IOException ioe = thrown()
            "Cannot run program \"blah\": error=2, No such file or directory" == ioe.getMessage()
    }

}
