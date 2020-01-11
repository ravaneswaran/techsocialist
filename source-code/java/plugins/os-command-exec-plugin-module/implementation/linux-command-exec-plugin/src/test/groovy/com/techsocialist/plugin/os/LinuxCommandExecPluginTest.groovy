package com.techsocialist.plugin.os


import com.techsocialist.plugin.os.util.OSCommandExecPluginUtil
import spock.lang.Specification

class LinuxCommandExecPluginTest extends Specification {

    def "executing the command ls -la through the OSCommandExecPluginUtil.getOSCommandExecPlugin"() {
        setup:
        def commandExecService = OSCommandExecPluginUtil.getOSCommandExecPlugin("com.techsocialist.plugin.os.LinuxCommandExecPlugin")
        def command = "ls -la"
        when:
        commandExecService.executeCommand(command)
        then:
        null != commandExecService.getOutput()
    }

    def "executing the command ls -la"() {
        setup:
        def linuxCommandExecService = new LinuxCommandExecPlugin()
        def command = "ls -la"
        when:
        linuxCommandExecService.executeCommand(command)
        then:
        null != linuxCommandExecService.getOutput()

    }

    def "executing an invalid command"() {
        setup:
        def linuxCommandExecService = new LinuxCommandExecPlugin()
        def command = "blah"
        when:
        linuxCommandExecService.executeCommand(command)
        then:
        "bash: blah: command not found\n" == linuxCommandExecService.getError()
    }

}
