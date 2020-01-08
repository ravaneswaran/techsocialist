package com.techsocialist.plugin.mail.java

import spock.lang.Specification

class JavaMailServiceTest extends Specification{

    def "test connecting to a mail server"(){
        setup :
            def javaMailService = new JavaMailService()
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
        when :
            def result = javaMailService.connect(host, port, userName, password)
        then :
            result == 0
    }

    def "test when sending a mail from from@from.com to to@to.com"(){
        setup :
            def javaMailService = new JavaMailService()
            def from = "from@from.com"
            def to = "to@to.com"
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
            javaMailService.connect(host, port, userName, password)
        when :
            javaMailService.sendMail(from, to, "Test Subject", "Test Message")
        then :
            0 == javaMailService.getStatus()
    }

}
