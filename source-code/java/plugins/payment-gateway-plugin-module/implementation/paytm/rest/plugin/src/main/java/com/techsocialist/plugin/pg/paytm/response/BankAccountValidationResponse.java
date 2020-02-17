package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.BankAccountValidationResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.BankAccountValidationResponseHead;

public class BankAccountValidationResponse extends AbstractPaytmResponse{

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private BankAccountValidationResponseHead bankAccountValidationResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private BankAccountValidationResponseBody bankAccountValidationResponseBody;

    public BankAccountValidationResponseHead getBankAccountValidationResponseHead() {
        return bankAccountValidationResponseHead;
    }

    public BankAccountValidationResponseBody getBankAccountValidationResponseBody() {
        return bankAccountValidationResponseBody;
    }
}
