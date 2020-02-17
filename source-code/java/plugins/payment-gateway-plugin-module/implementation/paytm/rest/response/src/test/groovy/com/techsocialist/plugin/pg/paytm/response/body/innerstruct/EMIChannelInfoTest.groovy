package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class EMIChannelInfoTest extends Specification{

    def "test EMIChannelInfo -> planId"(){

        setup:
        EMIChannelInfo emiChannelInfo = new EMIChannelInfo("123", "10.0", "2", null, null, null, null)

        when:
        String result = emiChannelInfo.getPlanId()

        then:
        "123" == result
    }

    def "test EMIChannelInfo -> interestRate"(){

        setup:
        EMIChannelInfo emiChannelInfo = new EMIChannelInfo(planId: "123", interestRate: "10.0", ofMonths: "2", minAmount: null, maxAmount: null, emiAmount: null, totalAmount: null)

        when:
        String result = emiChannelInfo.getInterestRate()

        then:
        "10.0" == result
    }

    def "test EMIChannelInfo -> ofMonths"(){

        setup:
        EMIChannelInfo emiChannelInfo = new EMIChannelInfo(planId: "123", interestRate: "10.0", ofMonths: "2", minAmount: null, maxAmount: null, emiAmount: null, totalAmount: null)

        when:
        String result = emiChannelInfo.getOfMonths()

        then:
        "2" == result
    }

    def "test EMIChannelInfo -> minAmount"(){

        setup:
        EMIChannelInfo emiChannelInfo = new EMIChannelInfo(planId: "123", interestRate: "10.0", ofMonths: "2", minAmount: null, maxAmount: null, emiAmount: null, totalAmount: null)

        when:
        String result = emiChannelInfo.getMinAmount()

        then:
        null == result
    }

    def "test EMIChannelInfo -> maxAmount"(){

        setup:
        EMIChannelInfo emiChannelInfo = new EMIChannelInfo(planId: "123", interestRate: "10.0", ofMonths: "2", minAmount: null, maxAmount: null, emiAmount: null, totalAmount: null)

        when:
        String result = emiChannelInfo.getMaxAmount()

        then:
        null == result
    }

    def "test EMIChannelInfo -> emiAmount"(){

        setup:
        EMIChannelInfo emiChannelInfo = new EMIChannelInfo(planId: "123", interestRate: "10.0", ofMonths: "2", minAmount: null, maxAmount: null, emiAmount: null, totalAmount: null)

        when:
        String result = emiChannelInfo.getEmiAmount()

        then:
        null == result
    }

    def "test EMIChannelInfo -> totalAmount"(){

        setup:
        EMIChannelInfo emiChannelInfo = new EMIChannelInfo(planId: "123", interestRate: "10.0", ofMonths: "2", minAmount: null, maxAmount: null, emiAmount: null, totalAmount: null)

        when:
        String result = emiChannelInfo.getTotalAmount()

        then:
        null == result
    }
}

