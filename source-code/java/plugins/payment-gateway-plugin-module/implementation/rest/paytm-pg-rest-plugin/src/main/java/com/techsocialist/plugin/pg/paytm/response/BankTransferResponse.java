package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.BankTransferResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.BankTransferResponseHead;

public class BankTransferResponse extends AbstractPaytmResponse{

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private BankTransferResponseHead bankTransferResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private BankTransferResponseBody bankTransferResponseBody;

    public BankTransferResponseHead getBankTransferResponseHead() {
        return bankTransferResponseHead;
    }

    public BankTransferResponseBody getBankTransferResponseBody() {
        return bankTransferResponseBody;
    }
}
