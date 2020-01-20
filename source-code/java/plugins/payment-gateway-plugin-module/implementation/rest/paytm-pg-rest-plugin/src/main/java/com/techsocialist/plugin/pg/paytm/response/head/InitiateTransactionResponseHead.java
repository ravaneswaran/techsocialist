package com.techsocialist.plugin.pg.paytm.response.head;

import com.google.gson.annotations.SerializedName;

public class InitiateTransactionResponseHead extends AbstractPaytmResponseHead{

    @SerializedName("signature")
    private String signature;

    public String getSignature() {
        return signature;
    }
}
