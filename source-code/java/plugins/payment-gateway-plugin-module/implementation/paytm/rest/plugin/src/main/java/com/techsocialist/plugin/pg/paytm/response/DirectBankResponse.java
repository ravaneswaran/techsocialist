package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.DirectBankResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.DirectBankResponseHead;

public class DirectBankResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private DirectBankResponseHead directBankResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private DirectBankResponseBody directBankResponseBody;

    public DirectBankResponseHead getDirectBankResponseHead() {
        return directBankResponseHead;
    }

    public DirectBankResponseBody getDirectBankResponseBody() {
        return directBankResponseBody;
    }
}
