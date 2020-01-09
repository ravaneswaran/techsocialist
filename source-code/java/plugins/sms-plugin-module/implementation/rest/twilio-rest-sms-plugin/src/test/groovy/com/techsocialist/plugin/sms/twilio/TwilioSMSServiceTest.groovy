package com.techsocialist.plugin.sms.twilio

import com.techsocialist.plugin.sms.service.util.SMSUtil
import spock.lang.Ignore
import spock.lang.Specification

class TwilioSMSServiceTest extends Specification{

    def "test initialize sms service"(){
        setup:
            def twilioSMSService = new TwilioSMSService()
        when :
            twilioSMSService.initialize("", "")
        then :
            RuntimeException rte = thrown()
            "account ID/SID cannot be null or empty..." == rte.getMessage()
    }

    @Ignore
    def "test sending Hello World message to mobile number +919894794196"(){
        setup:
            def twilioSMSService = new TwilioSMSService()
            twilioSMSService.initialize(properties.get("sms.account.id"), properties.get("sms.account.auth.token"))
        when :
            String result = twilioSMSService.sendSMS(properties.get("sms.from.mobile.number"), "+919894794196", "Hello World")
        then :
            null != result && !result.isEmpty()
    }

    @Ignore
    def "test sending Hello World message to mobile number +919894794196 using service"(){
        setup:
            def twilioSMSService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.twilio.TwilioSMSService")
            twilioSMSService.initialize(properties.get("sms.account.id"), properties.get("sms.account.auth.token"))
        when :
            String result = twilioSMSService.sendSMS(properties.get("sms.from.mobile.number"), "+919894794196", "Hello World")
        then :
            null != result && !result.isEmpty()
    }

    def getProperties(){
        Properties properties = new Properties()

        properties.put("sms.account.id", "ACcd1bfb5fb1226482df6fe075fbb3af4f")
        properties.put("sms.account.auth.token", "0e4c956ff5d748ddf248faf65d826a1f")
        properties.put("sms.from.mobile.number", "+16232422765")

        properties
    }
}
