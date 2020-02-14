package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class MerchantRemainingLimit {

    @SerializedName("limitType")
    private String limitType;

    @SerializedName("amount")
    private String amount;

    public String getLimitType() {
        return limitType;
    }

    public String getAmount() {
        return amount;
    }
}
