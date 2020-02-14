package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.TransactionInfo;

public class DirectBankResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("callBackUrl")
    private String callBackUrl;

    @SerializedName("txnInfo")
    private TransactionInfo transactionInfo;

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }
}
