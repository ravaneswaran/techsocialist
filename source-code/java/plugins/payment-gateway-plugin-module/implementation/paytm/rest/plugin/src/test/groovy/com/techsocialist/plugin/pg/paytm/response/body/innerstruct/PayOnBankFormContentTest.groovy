package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class PayOnBankFormContentTest extends Specification{

    def payOnBankFormContent = ['ICICI', 'ICICI', 'ICICI', 'ICICI', 'ICICI', 'ICICI', 'ICICI', 'ICICI', 'ICICI'] as PayOnBankFormContent

    def "test PayOnBankFormContent"(){

        setup:
        PayOnBankFormContent payOnBankFormContent1 = new PayOnBankFormContent()

        when:
        String result = payOnBankFormContent1.getBankCode()

        then:
        null == result

    }

    def "test PayOnBankFormContent -> bankCode"(){

        when:
        String result = payOnBankFormContent.getBankCode()

        then:
        null != result && "ICICI" == result

    }

    def "test PayOnBankFormContent -> mbid"(){

        when:
        String result = payOnBankFormContent.getMbid()

        then:
        null != result && "ICICI" == result

    }

    def "test PayOnBankFormContent -> orderId"(){

        when:
        String result = payOnBankFormContent.getOrderId()

        then:
        null != result && "ICICI" == result

    }

    def "test PayOnBankFormContent -> transactionAmount"(){

        when:
        String result = payOnBankFormContent.getTransactionAmount()

        then:
        null != result && "ICICI" == result

    }

    def "test PayOnBankFormContent -> paymentMode"(){

        when:
        String result = payOnBankFormContent.getPaymentMode()

        then:
        null != result && "ICICI" == result

    }

    def "test PayOnBankFormContent -> response"(){

        when:
        String result = payOnBankFormContent.getResponse()

        then:
        null != result && "ICICI" == result
    }

    def "test PayOnBankFormContent -> bankAbbreviation"(){

        when:
        String result = payOnBankFormContent.getBankAbbreviation()

        then:
        null != result && "ICICI" == result
    }

    def "test PayOnBankFormContent -> channelId"(){

        when:
        String result = payOnBankFormContent.getChannelId()

        then:
        null != result && "ICICI" == result
    }

    def "test PayOnBankFormContent -> transactionId"(){

        when:
        String result = payOnBankFormContent.getTransactionId()

        then:
        null != result && "ICICI" == result
    }
}
