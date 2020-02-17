package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class PayOption {

    @SerializedName("payMethod")
    private String payMethod;

    @SerializedName("displayName")
    private String displayName;

    public PayOption(){}

    public PayOption(String payMethod, String displayName){
        this.payMethod = payMethod;
        this.displayName = displayName;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public String getDisplayName() {
        return displayName;
    }
}
