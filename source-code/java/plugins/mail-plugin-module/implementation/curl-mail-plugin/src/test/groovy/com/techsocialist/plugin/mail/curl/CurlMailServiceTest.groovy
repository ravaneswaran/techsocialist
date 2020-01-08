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
            IMailService.STATUS_SUCCESSs == result
    }

}
