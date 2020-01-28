package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class HeaderTest extends Specification {

    def "test Header -> contentType"(){
        setup:
        Header header = new Header()

        when:
        String result = header.getContentType()

        then:
        null == result
    }
}
