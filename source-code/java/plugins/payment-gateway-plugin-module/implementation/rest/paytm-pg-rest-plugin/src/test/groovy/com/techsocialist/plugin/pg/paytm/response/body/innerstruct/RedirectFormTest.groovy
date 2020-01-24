package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class RedirectFormTest extends Specification {

    def redirectForm = ["", "", new Header(), new CancelFormContent()] as RedirectForm

    def "test RedirectForm"(){
        setup:
        RedirectForm redirectForm1 = new RedirectForm()

        when:
        String result = redirectForm1.getActionUrl()

        then:
        null == result
    }

    def "test RedirectForm -> actionUrl"(){

        when:
        String result = redirectForm.getActionUrl()

        then:
        "" == result
    }

    def "test RedirectForm -> method"(){

        when:
        String result = redirectForm.getMethod()

        then:
        "" == result
    }

    def "test RedirectForm -> header"(){

        when:
        String result = redirectForm.getHeader()

        then:
        null != result
    }

    def "test RedirectForm -> content"(){

        when:
        String result = redirectForm.getContent()

        then:
        null != result
    }
}
