package com.techsocialist.plugin.sms.service.api;

public interface ISMSService {

    public void initialize(String accountId, String authToken) throws Exception;

    public String sendSMS(String fromMobileNumber, String toMobileNumber, String message) throws Exception;
}
