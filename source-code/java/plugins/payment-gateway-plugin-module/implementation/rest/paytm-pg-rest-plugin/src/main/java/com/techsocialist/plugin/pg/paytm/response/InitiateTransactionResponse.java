package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.InitiateTransactionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.InitiateTransactionResponseHead;


public class InitiateTransactionResponse extends AbstractPaytmResponse{

    @SerializedName("head")
    private InitiateTransactionResponseHead initiateTransactionResponseHead;

    @SerializedName("body")
    private InitiateTransactionResponseBody initiateTransactionResponseBody;

    public InitiateTransactionResponseHead getInitiateTransactionResponseHead() {
        return initiateTransactionResponseHead;
    }

    public InitiateTransactionResponseBody getInitiateTransactionResponseBody() {
        return initiateTransactionResponseBody;
    }

    public boolean isOk() {
        return null != this.initiateTransactionResponseBody ? this.initiateTransactionResponseBody.isOK() : false;
    }
}
