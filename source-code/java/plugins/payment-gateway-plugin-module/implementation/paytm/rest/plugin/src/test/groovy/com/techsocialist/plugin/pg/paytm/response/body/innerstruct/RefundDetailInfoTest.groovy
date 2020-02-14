package com.techsocialist.plugin.pg.paytm.response.body.innerstruct

import spock.lang.Specification

class RefundDetailInfoTest extends Specification{

    def "test RefundDetailInfo "(){
        setup:
        RefundDetailInfo refundDetailInfo = new RefundDetailInfo()

        when:
        String result = refundDetailInfo.getRefundType()

        then:
        null == result
    }

    def "test RefundDetailInfo -> refundType"(){
        setup:
        RefundDetailInfo refundDetailInfo = new RefundDetailInfo("refundType", "payMethod", "userCreditExpectedDate", "userMobileNumber", "refundAmount")

        when:
        String result = refundDetailInfo.getRefundType()

        then:
        "refundType" == result
    }

    def "test RefundDetailInfo -> payMethod"(){
        setup:
        RefundDetailInfo refundDetailInfo = new RefundDetailInfo("refundType", "payMethod", "userCreditExpectedDate", "userMobileNumber", "refundAmount")

        when:
        String result = refundDetailInfo.getPayMethod()

        then:
        "payMethod" == result
    }

    def "test RefundDetailInfo -> userCreditExpectedDate"(){
        setup:
        RefundDetailInfo refundDetailInfo = new RefundDetailInfo("refundType", "payMethod", "userCreditExpectedDate", "userMobileNumber", "refundAmount")

        when:
        String result = refundDetailInfo.getUserCreditExpectedDate()

        then:
        "userCreditExpectedDate" == result
    }

    def "test RefundDetailInfo -> userMobileNumber"(){
        setup:
        RefundDetailInfo refundDetailInfo = new RefundDetailInfo("refundType", "payMethod", "userCreditExpectedDate", "userMobileNumber", "refundAmount")

        when:
        String result = refundDetailInfo.getUserMobileNumber()

        then:
        "userMobileNumber" == result
    }

    def "test RefundDetailInfo -> refundAmount"(){
        setup:
        RefundDetailInfo refundDetailInfo = new RefundDetailInfo("refundType", "payMethod", "userCreditExpectedDate", "userMobileNumber", "refundAmount")

        when:
        String result = refundDetailInfo.getRefundAmount()

        then:
        "refundAmount" == result
    }

}
