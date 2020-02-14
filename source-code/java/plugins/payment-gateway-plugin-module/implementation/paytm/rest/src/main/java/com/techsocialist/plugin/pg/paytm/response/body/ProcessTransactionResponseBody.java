package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.BankForm;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.TransactionInfo;

public class ProcessTransactionResponseBody extends AbstractPaytmResponseBody{

    @SerializedName("bankForm")
    private BankForm bankForm;

    @SerializedName("txnInfo")
    private TransactionInfo transactionInfo;

    @SerializedName("callBackUrl")
    private String callBackUrl;

    public BankForm getBankForm() {
        return bankForm;
    }

    public TransactionInfo getTransactionInfo() {
        return transactionInfo;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }
}
