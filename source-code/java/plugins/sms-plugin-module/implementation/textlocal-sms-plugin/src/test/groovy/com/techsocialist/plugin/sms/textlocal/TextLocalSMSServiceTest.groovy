package com.techsocialist.plugin.sms.textlocal

import com.techsocialist.plugin.sms.service.api.ISMSService
import com.techsocialist.plugin.sms.service.api.ITextLocalSMSService
import com.techsocialist.plugin.sms.service.util.SMSUtil
import spock.lang.Specification

class TextLocalSMSServiceTest extends Specification{

    def getProperties(){
        Properties properties = new Properties()
        properties.put("sms.textlocal.apikey", "pdYZ6VKeU6g-wPxVchq5NusIxcO7DSwdrzVb9JmRmD")
        properties.put("sms.textlocal.from", "TXTLCL")
        properties
    }

    def "test initialize sms service with the api key"(){
        setup:
            def textLocalService = new TextLocalSMSService()
        when :
            def result = textLocalService.initialize("123")
        then :
            null == result
    }

    def "test initialize sms service with null or empty api key"(){
        setup:
            def textLocalService = new TextLocalSMSService()
        when :
            textLocalService.initialize("")
        then :
            RuntimeException rt =  thrown()
            "apiKey cannot be null or empty..." == rt.getMessage()
    }

    def "test sending Hello World message to mobile number when from mobile number is null or empty"(){
        setup:
            ITextLocalSMSService smsService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.textlocal.TextLocalSMSService")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            ((ISMSService)smsService).sendSMS(null, "+919894794196", "Hello World")
        then :
            RuntimeException re = thrown()
            "from(SMS Source) cannot be null or empty..." == re.getMessage()
    }

    def "test sending Hello World message to mobile number when to mobile number is null or empty"(){
        setup:
            ITextLocalSMSService smsService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.textlocal.TextLocalSMSService")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            ((ISMSService)smsService).sendSMS(properties.get("sms.textlocal.from"), null, "Hello World")
        then :
            RuntimeException re = thrown()
            "to(SMS Destination) cannot be null or empty..." == re.getMessage()
    }

    def "test sending null or empty message to mobile number +919894794196 using service"(){
        setup:
            ITextLocalSMSService smsService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.textlocal.TextLocalSMSService")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            ((ISMSService)smsService).sendSMS(properties.get("sms.textlocal.from"), "+919894794196", null)
        then :
            RuntimeException re = thrown()
            "message cannot be null or empty..." == re.getMessage()
    }

    def "test sending Hello World message to a mobile number"(){
        setup:
            ITextLocalSMSService smsService = SMSUtil.getSMSService("com.techsocialist.plugin.sms.textlocal.TextLocalSMSService")
            smsService.initialize(properties.get("sms.textlocal.apikey"))
        when :
            def result = ((ISMSService)smsService).sendSMS(properties.get("sms.textlocal.from"), "+919894794196", "Hello World")
        then :
            null != result
    }
}
