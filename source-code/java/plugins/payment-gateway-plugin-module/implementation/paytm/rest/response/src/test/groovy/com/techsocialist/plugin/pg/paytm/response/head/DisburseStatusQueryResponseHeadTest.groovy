package com.techsocialist.plugin.pg.paytm.response.head

import spock.lang.Specification

class DisburseStatusQueryResponseHeadTest extends Specification{


    def "test DisburseStatusQueryResponseHead instance"(){
        when:
        DisburseStatusQueryResponseHead disburseStatusQueryResponseHead = new DisburseStatusQueryResponseHead()

        then:
        null != disburseStatusQueryResponseHead
    }

}
