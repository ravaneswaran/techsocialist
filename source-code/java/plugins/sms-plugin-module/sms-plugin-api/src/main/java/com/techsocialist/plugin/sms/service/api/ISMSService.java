package com.techsocialist.plugin.sms.service.api;

public interface ISMSService {

    public String sendSMS(String from, String to, String message) throws Exception;

}
