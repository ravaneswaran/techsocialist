package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class SubmitFormContentTest extends Specification {

    def "test SubmitFormContent instance"(){

        setup:
        SubmitFormContent submitFormContent = new SubmitFormContent()

        when:
        String result = submitFormContent.getOtp()

        then:
        null == result
    }

    def "test SubmitFormContent -> transactionToken"(){

        setup:
        SubmitFormContent submitFormContent = new SubmitFormContent()

        when:
        String result = submitFormContent.getTransactionToken()

        then:
        null == result
    }

    def "test SubmitFormContent -> requestType"(){

        setup:
        SubmitFormContent submitFormContent = new SubmitFormContent()

        when:
        String result = submitFormContent.getRequestType()

        then:
        null == result
    }
}
