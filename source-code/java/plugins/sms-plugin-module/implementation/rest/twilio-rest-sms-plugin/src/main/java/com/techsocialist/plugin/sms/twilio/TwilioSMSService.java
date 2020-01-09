package com.techsocialist.plugin.sms.twilio;

import com.techsocialist.plugin.sms.service.impl.AbstractSMSService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioSMSService extends AbstractSMSService {

    @Override
    public String sendSMS(String fromMobileNumber, String toMobileNumber, String message) throws Exception{

        if(null == fromMobileNumber || fromMobileNumber.isEmpty()){
            throw new RuntimeException("fromMobileNumber cannot be null or empty...");
        }

        if(null == toMobileNumber || toMobileNumber.isEmpty()){
            throw new RuntimeException("toMobileNumber cannot be null or empty...");
        }

        if(null == message || message.isEmpty()){
            throw new RuntimeException("message cannot be null or empty...");
        }

        Twilio.init(this.accountId, this.authToken);
        Message twilioMessage = Message.creator(
                new PhoneNumber(toMobileNumber),
                new PhoneNumber(fromMobileNumber),
                message)
                .create();

        System.out.println(twilioMessage.getBody());

        return twilioMessage.getSid();
    }
}
