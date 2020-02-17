package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchTransactionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchTransactionResponseHead;

public class FetchTransactionResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private FetchTransactionResponseHead fetchTransactionResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private FetchTransactionResponseBody fetchTransactionResponseBody;

    public FetchTransactionResponseHead getFetchTransactionResponseHead() {
        return fetchTransactionResponseHead;
    }

    public FetchTransactionResponseBody getFetchTransactionResponseBody() {
        return fetchTransactionResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getFetchTransactionResponseBody().ok();
    }
}
