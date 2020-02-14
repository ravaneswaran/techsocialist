package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NBPayOption {

    @SerializedName("displayName")
    private String displayName;

    @SerializedName("feeAmount")
    private String feeAmount;

    @SerializedName("taxAmount")
    private String taxAmount;

    @SerializedName("totalTransactionAmount")
    private String totalTransactionAmount;

    @SerializedName("priority")
    private String priority;

    @SerializedName("onboarding")
    private boolean onboarding;

    @SerializedName("paymentMode")
    private String paymentMode;

    @SerializedName("isHybridDisabled")
    private boolean isHybridDisabled;

    @SerializedName("isDisabled")
    private IsDisabled isDisabled;

    @SerializedName("payChannelOptions")
    private List<PayChannelOption> payChannelOptions;

    public String getDisplayName() {
        return displayName;
    }

    public String getFeeAmount() {
        return feeAmount;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public String getTotalTransactionAmount() {
        return totalTransactionAmount;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isOnboarding() {
        return onboarding;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public boolean isHybridDisabled() {
        return isHybridDisabled;
    }

    public IsDisabled getIsDisabled() {
        return isDisabled;
    }

    public List<PayChannelOption> getPayChannelOptions() {
        return payChannelOptions;
    }
}
