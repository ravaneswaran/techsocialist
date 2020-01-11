package com.techsocialist.plugin.sms

import com.techsocialist.plugin.sms.api.ISMSPlugin
import com.techsocialist.plugin.sms.api.ITextLocalSMSPlugin
import com.techsocialist.plugin.sms.util.SMSPluginUtil
import spock.lang.Specification

class TextLocalSMSPluginTest extends Specification{

    def getProperties(){
        Properties properties = new Properties()
        properties.put("sms.textlocal.apikey", "pdYZ6VKeU6g-wPxVchq5NusIxcO7DSwdrzVb9JmRmD")
        properties.put("sms.textlocal.from", "TXTLCL")
        properties
    }

    def "test initialize sms service with the api key"(){
        setup:
            def textLocalService = new TextLocalSMSPlugin()
        when :
            def result = textLocalService.initialize("123")
        then :
            null == result
    }

    def "test initialize sms service with null or empty api key"(){
        setup:
            def textLocalService = new TextLocalSMSPlugin()
        when :
            textLocalService.initialize("")
        then :
            RuntimeException rt =  thrown()
            "apiKey cannot be null or empty..." == rt.getMessage()
    }

    def "test sending Hello World message to mobile number when from mobile number is null or empty"(){
        setup:
            ITextLocalSMSPlugin smsService = SMSPluginUtil.getSMSPlugin("TextLocalSMSPlugin")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            ((ISMSPlugin)smsService).sendSMS(null, "+919894794196", "Hello World")
        then :
            RuntimeException re = thrown()
            "from(SMS Source) cannot be null or empty..." == re.getMessage()
    }

    def "test sending Hello World message to mobile number when to mobile number is null or empty"(){
        setup:
            ITextLocalSMSPlugin smsService = SMSPluginUtil.getSMSPlugin("TextLocalSMSPlugin")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            ((ISMSPlugin)smsService).sendSMS(properties.get("sms.textlocal.from"), null, "Hello World")
        then :
            RuntimeException re = thrown()
            "to(SMS Destination) cannot be null or empty..." == re.getMessage()
    }

    def "test sending null or empty message to mobile number +919894794196 using service"(){
        setup:
            ITextLocalSMSPlugin smsService = SMSPluginUtil.getSMSPlugin("TextLocalSMSPlugin")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            ((ISMSPlugin)smsService).sendSMS(properties.get("sms.textlocal.from"), "+919894794196", null)
        then :
            RuntimeException re = thrown()
            "message cannot be null or empty..." == re.getMessage()
    }

    def "test sending Hello World message to a mobile number"(){
        setup:
            ITextLocalSMSPlugin smsService = SMSPluginUtil.getSMSPlugin("TextLocalSMSPlugin")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            def result = ((ISMSPlugin)smsService).sendSMS(properties.get("sms.textlocal.from"), "+919894794196", "Hello World")
        then :
            null != result
    }
}
