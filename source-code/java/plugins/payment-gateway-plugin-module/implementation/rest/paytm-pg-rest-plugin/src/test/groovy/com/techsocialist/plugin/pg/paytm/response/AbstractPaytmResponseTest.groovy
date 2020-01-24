package com.techsocialist.plugin.pg.paytm.response

import org.joda.time.DateTime
import spock.lang.Specification

class AbstractPaytmResponseTest extends Specification{

    def fakeMerchantId = "utsdifs6789"

    def merchantId = "MqSnHc74327968593861"
    def merchantKey = "NgOnN7UT22rslD!%"

    def domesticMasterCreditCardOne = "5104 0155 5555 5558"
    def domesticMasterCreditCardTwo = "5104 0600 0000 0008"

    def domesticVisaCreditCard = "4111 1111 1111 1111"

    def creditCardCVV = "123"

    def currentDate = new DateTime(new Date().getTime())
    def futureMonth = String.valueOf(currentDate.plusMonths(24).getMonthOfYear())
    def futureYear = String.valueOf(currentDate.plusMonths(24).getYear())

    def walletMobileNumber = "77777 77777"
    def walletPassword = "Paytm12345"
    def walletOTP = "489871"

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
