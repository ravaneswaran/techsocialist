package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MerchantLimitInfo {

    @SerializedName("merchantRemainingLimits")
    private List<MerchantRemainingLimit> merchantRemainingLimits;

    @SerializedName("excludePayModes")
    private List<ExcludePayMode> excludePayModes;

    @SerializedName("message")
    private String message;

    public List<MerchantRemainingLimit> getMerchantRemainingLimits() {
        return merchantRemainingLimits;
    }

    public List<ExcludePayMode> getExcludePayModes() {
        return excludePayModes;
    }

    public String getMessage() {
        return message;
    }
}
