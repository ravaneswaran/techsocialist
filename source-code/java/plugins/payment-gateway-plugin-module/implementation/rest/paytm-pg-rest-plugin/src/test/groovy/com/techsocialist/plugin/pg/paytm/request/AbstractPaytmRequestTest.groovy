package com.techsocialist.plugin.pg.paytm.request

import org.json.JSONObject
import spock.lang.Specification

class AbstractPaytmRequestTest extends Specification{

    def "test data"(){
        setup:
        AbstractPaytmRequest paytmRequest = new BalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setMerchantKey("mer-key")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setClientId("client-001")
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.data()
    }

    def "test data when dataHead and dataBody returns null"(){
        setup:
        AbstractPaytmRequest paytmRequest = new BalanceInfoRequest(){
            @Override
            JSONObject dataHead() {
                return null
            }

            @Override
            JSONObject dataBody() {
                return null
            }
        }

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setClientId("client-001")
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.data() && "{}".equals(paytmRequest.data().toString())
    }

    def "test data as json string"(){
        setup:
        AbstractPaytmRequest paytmRequest = new BalanceInfoRequest()

        when:
        paytmRequest.setMerchantId("mer-001")
        paytmRequest.setOrderId("order-001")
        paytmRequest.setVersion("v1")
        paytmRequest.setChannelId("WEB")
        paytmRequest.setClientId("client-001")
        paytmRequest.setTransactionToken("txn-001")

        then:
        null != paytmRequest.dataAsJsonString() && paytmRequest.dataAsJsonString().length() > 1
    }

    def "test generate checksum"(){
        setup:
        AbstractPaytmRequest paytmRequest = new InitiateTransactionRequest()
        paytmRequest.setMerchantKey("NgOnN7UT22rslD!%")

        when:
        JSONObject jsonObject = new JSONObject()
        jsonObject.put("KEY", "test-key")
        jsonObject.put("VALUE", "value")
        def checksum = paytmRequest.generateChecksum(jsonObject)

        then:
        null != checksum
    }

    def "test generate checksum when merchant key is null"(){
        setup:
        AbstractPaytmRequest paytmRequest = new InitiateTransactionRequest()


        when:
        JSONObject jsonObject = new JSONObject()
        jsonObject.put("KEY", "test-key")
        jsonObject.put("VALUE", "value")
        def checksum = paytmRequest.generateChecksum(jsonObject)

        then:
        null == checksum
    }

    def "test generate checksum when merchant key is invalid"(){
        setup:
        AbstractPaytmRequest paytmRequest = new InitiateTransactionRequest()
        paytmRequest.setMerchantKey("1234567")

        when:
        JSONObject jsonObject = new JSONObject()
        jsonObject.put("KEY", "test-key")
        jsonObject.put("VALUE", "value")
        def checksum = paytmRequest.generateChecksum(jsonObject)

        then:
        null != checksum
    }

}
