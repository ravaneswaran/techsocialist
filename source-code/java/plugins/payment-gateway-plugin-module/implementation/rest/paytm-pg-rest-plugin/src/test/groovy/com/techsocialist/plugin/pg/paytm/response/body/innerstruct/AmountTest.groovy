package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class AmountTest extends Specification{

    def "test Amount -> currency"(){

        setup:
        Amount amount = new Amount("INR","100.00")

        when:
        String result = amount.getCurrency()

        then:
        "INR" == result
    }

    def "test Amount -> value"(){

        setup:
        Amount amount = new Amount(currency: "INR", value: "100.00")

        when:
        String result = amount.getValue()

        then:
        "100.00" == result
    }
}
