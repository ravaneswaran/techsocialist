package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class ExcludePayModeTest extends Specification{

    def "test ExcludePayMode instance"(){
        when:
        ExcludePayMode excludePayMode = new ExcludePayMode()

        then:
        null != excludePayMode
    }
}