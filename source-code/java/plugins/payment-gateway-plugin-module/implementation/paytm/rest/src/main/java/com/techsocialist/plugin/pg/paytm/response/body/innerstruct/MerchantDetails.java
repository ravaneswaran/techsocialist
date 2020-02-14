package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class MerchantDetails {

    @SerializedName("mcc")
    private String mcc;

    @SerializedName("merchantVpa")
    private String merchantVpa;

    @SerializedName("merchantName")
    private String merchantName;

    @SerializedName("merchantLogo")
    private String merchantLogo;

    public String getMcc() {
        return mcc;
    }

    public String getMerchantVpa() {
        return merchantVpa;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public String getMerchantLogo() {
        return merchantLogo;
    }
}
