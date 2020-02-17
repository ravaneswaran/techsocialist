package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class PayChannelOption {

    @SerializedName("isDisabled")
    private IsDisabled isDisabled;

    @SerializedName("hasLowSuccess")
    private HasLowSuccess hasLowSuccess;

    @SerializedName("iconUrl")
    private String iconUrl;

    @SerializedName("balanceInfo")
    private String balanceInfo;

    @SerializedName("isHybridDisabled")
    private boolean isHybridDisabled;

    public IsDisabled getIsDisabled() {
        return isDisabled;
    }

    public HasLowSuccess getHasLowSuccess() {
        return hasLowSuccess;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getBalanceInfo() {
        return balanceInfo;
    }

    public boolean isHybridDisabled() {
        return isHybridDisabled;
    }
}
