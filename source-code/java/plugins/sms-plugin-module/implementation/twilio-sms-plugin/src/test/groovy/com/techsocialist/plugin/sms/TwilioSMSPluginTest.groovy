package com.techsocialist.plugin.sms

import com.techsocialist.plugin.sms.api.ITwilioSMSPlugin
import com.techsocialist.plugin.sms.util.SMSPluginUtil
import spock.lang.Ignore
import spock.lang.Specification

class TwilioSMSPluginTest extends Specification{

    def getProperties(){
        Properties properties = new Properties()

        properties.put("sms.twilio.account.sid", "ACcd1bfb5fb1226482df6fe075fbb3af4f")
        properties.put("sms.twilio.auth.token", "0e4c956ff5d748ddf248faf65d826a1f")
        properties.put("sms.twilio.from", "+16232422765")

        properties
    }

    def "test initialize sms service when both are valid"(){
        setup:
            def smsService = new TwilioSMSPlugin()
        when :
            def result = smsService.initialize("123", "456")
        then :
            null == result
    }

    def "test initialize sms service when account sid is null or empty"(){
        setup:
            def smsService = new TwilioSMSPlugin()
        when :
            def result = smsService.initialize(null, "456")
        then :
            RuntimeException rt =  thrown()
            "account SID cannot be null or empty..." == rt.getMessage()
    }

    def "test initialize sms service when auth token is null or empty"(){
        setup:
            def smsService = new TwilioSMSPlugin()
        when :
            def result = smsService.initialize("123", null)
        then :
            RuntimeException rt =  thrown()
            "authToken cannot be null or empty..." == rt.getMessage()
    }

    @Ignore
    def "test sending Hello World message to mobile number +919894794196"(){
        setup:
            def smsService = new TwilioSMSPlugin()
            smsService.initialize(properties.get("sms.twilio.account.sid"), properties.get("sms.twilio.auth.token"))
        when :
            String result = smsService.sendSMS(properties.get("sms.from."), "+919894794196", "Hello World")
        then :
            null != result && !result.isEmpty()
    }

    @Ignore
    def "test sending Hello World message to mobile number +919894794196 using service"(){
        setup:
            def smsService = SMSPluginUtil.getSMSPlugin("TwilioSMSPlugin")
            ITwilioSMSPlugin twilioSMSService = smsService
            twilioSMSService.initialize(properties.get("sms.twilio.account.sid"), properties.get("sms.twilio.auth.token"))
        when :
            String result = smsService.sendSMS(properties.get("sms.twilio.from"), "+919894794196", "Hello World")
        then :
            null != result && !result.isEmpty()
    }

    def "test sending Hello World message to mobile number when from mobile number is null or empty"(){
        setup:
            def smsService = SMSPluginUtil.getSMSPlugin("TwilioSMSPlugin")
            ITwilioSMSPlugin twilioSMSService = smsService
            twilioSMSService.initialize(properties.get("sms.twilio.account.sid"), properties.get("sms.twilio.auth.token"))
        when :
            smsService.sendSMS(null, "+919894794196", "Hello World")
        then :
            RuntimeException re = thrown()
            "from(SMS Source) cannot be null or empty..." == re.getMessage()
    }

    def "test sending Hello World message to mobile number when to mobile number is null or empty"(){
        setup:
            def smsService = SMSPluginUtil.getSMSPlugin("TwilioSMSPlugin")
            ITwilioSMSPlugin twilioSMSService = smsService
            twilioSMSService.initialize(properties.get("sms.twilio.account.sid"), properties.get("sms.twilio.auth.token"))
        when :
            smsService.sendSMS(properties.get("sms.twilio.from"), null, "Hello World")
        then :
            RuntimeException re = thrown()
            "to(SMS Destination) cannot be null or empty..." == re.getMessage()
    }

    def "test sending null or empty message to mobile number +919894794196 using service"(){
        setup:
            def smsService = SMSPluginUtil.getSMSPlugin("TwilioSMSPlugin")
            ITwilioSMSPlugin twilioSMSService = smsService
            twilioSMSService.initialize(properties.get("sms.twilio.account.sid"), properties.get("sms.twilio.auth.token"))
        when :
            smsService.sendSMS(properties.get("sms.twilio.from"), "+919894794196", null)
        then :
            RuntimeException re = thrown()
            "message cannot be null or empty..." == re.getMessage()
    }
}
