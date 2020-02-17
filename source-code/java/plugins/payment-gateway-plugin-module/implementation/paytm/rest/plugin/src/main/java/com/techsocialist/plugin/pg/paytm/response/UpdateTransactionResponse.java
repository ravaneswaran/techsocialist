package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.UpdateTransactionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.UpdateTransactionResponseHead;

public class UpdateTransactionResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private UpdateTransactionResponseHead updateTransactionResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private UpdateTransactionResponseBody updateTransactionResponseBody;

    public UpdateTransactionResponseHead getUpdateTransactionResponseHead() {
        return updateTransactionResponseHead;
    }

    public UpdateTransactionResponseBody getUpdateTransactionResponseBody() {
        return updateTransactionResponseBody;
    }

    @Override
    public boolean ok() {
        return this.updateTransactionResponseBody.ok();
    }
}
