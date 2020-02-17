package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public abstract class FormContent {

    @SerializedName("txnToken")
    private String transactionToken;

    @SerializedName("requestType")
    private String requestType;

    public String getTransactionToken() {
        return transactionToken;
    }

    public String getRequestType() {
        return requestType;
    }
}
