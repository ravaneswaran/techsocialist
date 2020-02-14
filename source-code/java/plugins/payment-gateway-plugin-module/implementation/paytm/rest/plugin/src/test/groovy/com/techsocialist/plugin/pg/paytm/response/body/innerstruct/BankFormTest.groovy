package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class BankFormTest extends Specification {

    def bankForm = new BankForm("", false, new RedirectForm(), new ArrayList<DirectForm>(), new DisplayField())

    def "test BankForm"(){

        setup:
        BankForm bankForm1 = new BankForm()

        when:
        String result = bankForm1.getPageType()

        then:
        null == result
    }

    def "test BankForm -> pageType"(){

        when:
        String result = bankForm.getPageType()

        then:
        "" == result
    }

    def "test BankForm -> isForceResendOtp"(){

        when:
        boolean result = bankForm.isForceResendOtp()

        then:
        false == result
    }

    def "test BankForm -> redirectForm"(){

        when:
        RedirectForm result = bankForm.getRedirectForm()

        then:
        null != result
    }

    def "test BankForm -> directForms"(){

        when:
        List<DirectForm> result = bankForm.getDirectForms()

        then:
        null != result && result.size() == 0
    }

    def "test BankForm -> displayField"(){

        when:
        DisplayField result = bankForm.getDisplayField()

        then:
        null != result
    }

}
