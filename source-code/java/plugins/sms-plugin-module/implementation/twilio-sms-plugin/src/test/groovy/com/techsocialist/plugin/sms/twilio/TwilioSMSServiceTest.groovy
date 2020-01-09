package com.techsocialist.plugin.sms.twilio

import com.techsocialist.plugin.sms.service.util.SMSUtil
import spock.lang.Ignore
import spock.lang.Specification

class TwilioSMSServiceTest extends Specification{

    def getProperties(){
        Properties properties = new Properties()

        properties.put("sms.account.id", "ACcd1bfb5fb1226482df6fe075fbb3af4f")
        properties.put("sms.account.auth.token", "0e4c956ff5d748ddf248faf65d826a1f")
        properties.put("sms.from.mobile.number", "+16232422765")

        properties
    }

    def "test initialize sms service when both are valid"(){
        setup:
            def twilioSMSService = new TwilioSMSService()
        when :
            def result = twilioSMSService.initialize("123", "456")
        then :
            null == result
    }

    def "test initialize sms service when account sid is null or empty"(){
        setup:
            def twilioSMSService = new TwilioSMSService()
        when :
            def result = twilioSMSService.initialize(null, "456")
        then :
            RuntimeException rt =  thrown()
            "account SID cannot be null or empty..." == rt.getMessage()
    }

    def "test initialize sms service when auth token is null or empty"(){
        setup:
            def twilioSMSService = new TwilioSMSService()
        when :
            def result = twilioSMSService.initialize("123", null)
        then :
            RuntimeException rt =  thrown()
            "authToken cannot be null or empty..." == rt.getMessage()
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

    def "test sending Hello World message to mobile number when from mobile number is null or empty"(){
        setup:
            def twilioSMSService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.twilio.TwilioSMSService")
            twilioSMSService.initialize(properties.get("sms.account.id"), properties.get("sms.account.auth.token"))
        when :
            String result = twilioSMSService.sendSMS(null, "+919894794196", "Hello World")
        then :
            RuntimeException re = thrown()
            "from(SMS Source) cannot be null or empty..." == re.getMessage()
    }

    def "test sending Hello World message to mobile number when to mobile number is null or empty"(){
        setup:
            def twilioSMSService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.twilio.TwilioSMSService")
            twilioSMSService.initialize(properties.get("sms.account.id"), properties.get("sms.account.auth.token"))
        when :
            String result = twilioSMSService.sendSMS(properties.get("sms.from.mobile.number"), null, "Hello World")
        then :
            RuntimeException re = thrown()
            "to(SMS Destination) cannot be null or empty..." == re.getMessage()
    }

    def "test sending null or empty message to mobile number +919894794196 using service"(){
        setup:
            def twilioSMSService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.twilio.TwilioSMSService")
            twilioSMSService.initialize(properties.get("sms.account.id"), properties.get("sms.account.auth.token"))
        when :
            String result = twilioSMSService.sendSMS(properties.get("sms.from.mobile.number"), "+919894794196", null)
        then :
            RuntimeException re = thrown()
            "message cannot be null or empty..." == re.getMessage()
    }
}
