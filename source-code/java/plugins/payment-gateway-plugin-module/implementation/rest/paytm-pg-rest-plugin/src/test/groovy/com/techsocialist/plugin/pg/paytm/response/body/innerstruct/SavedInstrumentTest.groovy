package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class SavedInstrumentTest extends Specification{

    def "test SavedInstrument instance"(){
        when:
        SavedInstrument savedInstrument = new SavedInstrument()

        then:
        null != savedInstrument
    }
}