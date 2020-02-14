package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ProcessTransactionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ProcessTransactionResponseHead;

public class ProcessTransactionResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private ProcessTransactionResponseHead processTransactionResponseHead;

    @SerializedName("body")
    private ProcessTransactionResponseBody processTransactionResponseBody;

    public ProcessTransactionResponseHead getProcessTransactionResponseHead() {
        return processTransactionResponseHead;
    }

    public ProcessTransactionResponseBody getProcessTransactionResponseBody() {
        return processTransactionResponseBody;
    }
}
