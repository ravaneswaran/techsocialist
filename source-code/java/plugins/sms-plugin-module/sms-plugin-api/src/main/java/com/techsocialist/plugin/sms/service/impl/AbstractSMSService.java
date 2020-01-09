package com.techsocialist.plugin.sms.service.impl;

import com.techsocialist.plugin.sms.service.api.ISMSService;

public abstract class AbstractSMSService implements ISMSService {

    protected String accountId;

    protected String authToken;

    @Override
    public void initialize(String accountId, String authToken) throws Exception{

        if(null == accountId || accountId.isEmpty()){
            throw new RuntimeException("account ID/SID cannot be null or empty...");
        }

        if(null == authToken || authToken.isEmpty()){
            throw new RuntimeException("authToken cannot be null or empty...");
        }

        this.accountId = accountId;
        this.authToken = authToken;
    }
}
