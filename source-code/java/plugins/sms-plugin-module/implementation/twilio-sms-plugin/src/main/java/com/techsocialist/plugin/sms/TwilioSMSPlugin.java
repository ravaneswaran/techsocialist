package com.techsocialist.plugin.sms;

import com.techsocialist.plugin.sms.api.ITwilioSMSPlugin;
import com.techsocialist.plugin.sms.impl.AbstractSMSPlugin;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioSMSPlugin extends AbstractSMSPlugin implements ITwilioSMSPlugin {

    protected String accountSID;

    protected String authToken;

    @Override
    public void initialize(String accountSID, String authToken) throws Exception {

        if (null == accountSID || accountSID.isEmpty()) {
            throw new RuntimeException("account SID cannot be null or empty...");
        }

        if (null == authToken || authToken.isEmpty()) {
            throw new RuntimeException("authToken cannot be null or empty...");
        }

        this.accountSID = accountSID;
        this.authToken = authToken;
    }

    @Override
    public String sendSMS(String from, String to, String message) throws Exception {

        if (null == from || from.isEmpty()) {
            throw new RuntimeException("from(SMS Source) cannot be null or empty...");
        }

        if (null == to || to.isEmpty()) {
            throw new RuntimeException("to(SMS Destination) cannot be null or empty...");
        }

        if (null == message || message.isEmpty()) {
            throw new RuntimeException("message cannot be null or empty...");
        }

        Twilio.init(this.accountSID, this.authToken);
        Message twilioMessage = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(from),
                message)
                .create();

        return twilioMessage.getSid();
    }
}
