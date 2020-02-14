package com.techsocialist.plugin.pg.paytm.response.body

import spock.lang.Specification

class DisburseStatusQueryResponseBodyTest extends Specification {

    def "test DisburseStatusQueryResponseBody"(){
        when:
        DisburseStatusQueryResponseBody disburseStatusQueryResponseBody = new DisburseStatusQueryResponseBody()

        then:
        null != disburseStatusQueryResponseBody
    }

}
