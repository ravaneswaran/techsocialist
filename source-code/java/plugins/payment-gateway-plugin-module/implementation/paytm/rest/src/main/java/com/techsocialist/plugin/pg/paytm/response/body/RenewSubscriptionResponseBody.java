package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;

public class RenewSubscriptionResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("txnId")
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public boolean ok() {
        return "900".equals(this.getResultInfo().getResultCode());
    }
}
