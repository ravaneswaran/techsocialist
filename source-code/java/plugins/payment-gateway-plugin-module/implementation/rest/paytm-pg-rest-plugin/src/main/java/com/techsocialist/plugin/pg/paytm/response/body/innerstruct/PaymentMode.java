package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaymentMode {

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
    private boolean onBoarding;

    @SerializedName("paymentMode")
    private String mode;

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

    public boolean isOnBoarding() {
        return onBoarding;
    }

    public String getMode() {
        return mode;
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
