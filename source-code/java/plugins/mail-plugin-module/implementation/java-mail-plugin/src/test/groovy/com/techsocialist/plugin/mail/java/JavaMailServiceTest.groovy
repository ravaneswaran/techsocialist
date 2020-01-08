package com.techsocialist.plugin.mail.java

import com.techsocialist.plugin.mail.service.api.IMailService
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
            IMailService.STATUS_SUCCESS == 0
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
            IMailService.STATUS_SUCCESS == javaMailService.getStatus()
    }

    def "test sending a mail when from email address is null or empty to to@to.com"(){
        setup :
            def javaMailService = new JavaMailService()
            def from = null
            def to = "to@to.com"
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
            javaMailService.connect(host, port, userName, password)
        when :
            javaMailService.sendMail(from, to, "Test Subject", "Test Message")
        then :
            thrown RuntimeException
    }

    def "test sending a mail when from email address is from@from.com and to email address is null or empty"(){
        setup :
            def javaMailService = new JavaMailService()
            def from = "from@from.com"
            def to = null
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
            javaMailService.connect(host, port, userName, password)
        when :
            javaMailService.sendMail(from, to, "Test Subject", "Test Message")
        then :
            thrown RuntimeException
    }

    def "test when sending a mail from from@from.com to to@to.com with one carbon copy"(){
        setup :
            def javaMailService = new JavaMailService()
            def from = "from@from.com"
            def to = "to@to.com"
            String[] ccs = ["cc@cc.com"]
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
            javaMailService.connect(host, port, userName, password)
        when :
            javaMailService.sendMail(from, to, ccs, "Test Subject", "Test Message")
        then :
            IMailService.STATUS_SUCCESS == javaMailService.getStatus()
    }

    def "test when sending a mail from from@from.com to to@to.com with one blind carbon copy"(){
        setup :
            def javaMailService = new JavaMailService()
            def from = "from@from.com"
            String[] tos = ["to@to.com"]
            String[] bccs = ["bcc@bcc.com"]
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
            javaMailService.connect(host, port, userName, password)
        when :
            javaMailService.sendMail(from, tos, null, bccs, null, "Test Subject", "Test Message")
        then :
            IMailService.STATUS_SUCCESS == javaMailService.getStatus()
    }

}
