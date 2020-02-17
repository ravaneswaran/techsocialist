package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class DirectFormTest extends Specification{

    def directForm = ["", "", "", new Header(), new ResendFormContent()] as DirectForm

    def "test DirectForm"(){
        setup:
        DirectForm directForm1 = new DirectForm()

        when:
        String result = directForm1.getActionUrl()

        then:
        null == result
    }

    def "test DirectForm -> actionUrl"(){

        when:
        String result = directForm.getActionUrl()

        then:
        "" == result
    }

    def "test DirectForm -> method"(){

        when:
        String result = directForm.getMethod()

        then:
        "" == result
    }

    def "test DirectForm -> type"(){

        when:
        String result = directForm.getType()

        then:
        "" == result
    }

    def "test DirectForm -> header"(){

        when:
        String result = directForm.getHeader()

        then:
        null != result
    }

    def "test DirectForm -> content"(){

        when:
        String result = directForm.getContent()

        then:
        null != result
    }

}
