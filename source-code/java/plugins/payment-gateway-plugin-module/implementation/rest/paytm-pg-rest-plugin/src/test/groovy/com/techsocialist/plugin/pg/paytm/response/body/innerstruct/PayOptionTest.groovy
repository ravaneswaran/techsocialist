package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class PayOptionTest extends Specification{

    def "test PayOption -> payMethod"(){
        when:
        PayOption payOption = new PayOption(payMethod: "one", displayName: "two")

        then:
        "one" == payOption.getPayMethod()
    }

    def "test PayOption -> displayName"(){
        when:
        PayOption payOption = new PayOption("one", "two")

        then:
        "two" == payOption.getDisplayName()
    }
}
