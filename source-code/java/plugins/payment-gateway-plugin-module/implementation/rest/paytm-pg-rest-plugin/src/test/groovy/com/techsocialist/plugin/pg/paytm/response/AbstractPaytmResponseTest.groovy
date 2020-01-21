package com.techsocialist.plugin.pg.paytm.response

import spock.lang.Specification

class AbstractPaytmResponseTest extends Specification{

    def "test ok of AbstractPaytmResponse"(){
        setup:
        def paytmResponse = new AbstractPaytmResponse() {
            @Override
            boolean ok() {
                return super.ok()
            }
        }

        when:
        boolean returnVal = paytmResponse.ok()

        then:
        false == returnVal
    }

}
