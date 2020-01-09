package com.techsocialist.plugin.mail.curl

import com.techsocialist.plugin.mail.service.api.IMailService
import spock.lang.Specification

class CurlMailServiceTest extends Specification{

    def "test connecting to a mail server"(){
        setup :
            def curlMailService = new CurlMailService()
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
        when :
            def result = curlMailService.connect(host, port, userName, password)
        then :
            IMailService.STATUS_SUCCESS == result
    }

    def "test when sending a mail from from@from.com to to@to.com"(){
        setup :
            def curlMailService = new CurlMailService()
            def from = "from@from.com"
            def to = "to@to.com"
            def host = "localhost"
            def port = "1025"
            def userName = ""
            def password = ""
            curlMailService.connect(host, port, userName, password)
        when :
            curlMailService.sendMail(from, to, "Test Subject", "Test Message")
        then :
            IMailService.STATUS_SUCCESS == curlMailService.getStatus()
    }

}
