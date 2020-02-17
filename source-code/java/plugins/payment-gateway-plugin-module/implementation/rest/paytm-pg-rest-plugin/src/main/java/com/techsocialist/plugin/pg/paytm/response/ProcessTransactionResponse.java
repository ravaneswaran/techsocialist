package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ProcessTransactionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ProcessTransactionResponseHead;

public class ProcessTransactionResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private ProcessTransactionResponseHead processTransactionResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private ProcessTransactionResponseBody processTransactionResponseBody;

    public ProcessTransactionResponseHead getProcessTransactionResponseHead() {
        return processTransactionResponseHead;
    }

    public ProcessTransactionResponseBody getProcessTransactionResponseBody() {
        return processTransactionResponseBody;
    }
}
