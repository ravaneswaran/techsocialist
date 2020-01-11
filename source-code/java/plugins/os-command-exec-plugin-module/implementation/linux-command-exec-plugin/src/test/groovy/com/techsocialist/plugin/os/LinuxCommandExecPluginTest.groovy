package com.techsocialist.plugin.os


import com.techsocialist.plugin.os.util.OSCommandExecPluginUtil
import spock.lang.Specification

class LinuxCommandExecPluginTest extends Specification{

    def "executing the command ls -la through the OSCommandExecUtil.getOSCommandExecService"(){
        setup :
            def commandExecService = OSCommandExecPluginUtil.getOSCommandExecService(LinuxCommandExecPlugin.class.getName())
            def command = "ls -la"
        when :
            commandExecService.executeCommand(command)
        then :
            null != commandExecService.getOutput()
    }

    def "executing the command ls -la"(){
        setup :
            def linuxCommandExecService = new LinuxCommandExecPlugin()
            def command = "ls -la"
        when :
            linuxCommandExecService.executeCommand(command)
        then :
            null != linuxCommandExecService.getOutput()

    }

    def "executing an invalid command"(){
        setup :
            def linuxCommandExecService = new LinuxCommandExecPlugin()
            def command = "blah"
        when :
            linuxCommandExecService.executeCommand(command)
        then :
            IOException ioe = thrown()
            "Cannot run program \"blah\": error=2, No such file or directory" == ioe.getMessage()
    }

}
