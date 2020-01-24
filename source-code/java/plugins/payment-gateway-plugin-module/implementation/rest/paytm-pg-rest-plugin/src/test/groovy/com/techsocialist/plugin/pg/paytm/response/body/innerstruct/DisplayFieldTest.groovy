package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class DisplayFieldTest extends Specification {

    def displayField = ["1000.00", "one", "two", "three", "four"] as DisplayField

    def "test DisplayField"(){

        setup:
        DisplayField displayField1 = new DisplayField()

        when:
        String result = displayField1.getAmount()

        then:
        null == result

    }

    def "test DisplayField -> amount"(){

        when:
        String result = displayField.getAmount()

        then:
        "1000.00" == result

    }

    def "test DisplayField -> headerText"(){

        when:
        String result = displayField.getHeaderText()

        then:
        "one" == result

    }

    def "test DisplayField -> bankName"(){

        when:
        String result = displayField.getBankName()

        then:
        "two" == result

    }

    def "test DisplayField -> bankLogo"(){

        when:
        String result = displayField.getBankLogo()

        then:
        "three" == result

    }

    def "test DisplayField -> descriptionText"(){

        when:
        String result = displayField.getDescriptionText()

        then:
        "four" == result

    }
}
