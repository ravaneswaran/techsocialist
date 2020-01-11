package com.techsocialist.plugin.sms.api;

public interface ISMSPlugin {

    public String sendSMS(String from, String to, String message) throws Exception;

}
