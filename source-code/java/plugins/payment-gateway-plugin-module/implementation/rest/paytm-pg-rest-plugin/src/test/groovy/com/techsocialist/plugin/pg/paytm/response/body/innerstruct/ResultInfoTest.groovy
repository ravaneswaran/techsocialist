package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class ResultInfoTest extends Specification {

    def "test ResultInfo when no ok"(){
        when:
        ResultInfo resultInfo = new ResultInfo("D", "3030", "test message")

        then:
        false == resultInfo.ok()
    }

    def "test ResultInfo when ok"(){
        when:
        ResultInfo resultInfo = new ResultInfo("S", "0000", "Success")

        then:
        true == resultInfo.ok()
    }
}
