package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class EMIChannelInfo {

    @SerializedName("planId")
    private String planId;

    @SerializedName("interestRate")
    private String interestRate;

    @SerializedName("ofMonths")
    private String ofMonths;

    @SerializedName("minAmount")
    private Amount minAmount;

    @SerializedName("maxAmount")
    private Amount maxAmount;

    @SerializedName("emiAmount")
    private Amount emiAmount;

    @SerializedName("totalAmount")
    private Amount totalAmount;

    public EMIChannelInfo(){}

    public EMIChannelInfo(String planId, String interestRate, String ofMonths, Amount minAmount, Amount maxAmount, Amount emiAmount, Amount totalAmount){
        this.planId = planId;
        this.interestRate = interestRate;
        this.ofMonths = ofMonths;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.emiAmount = emiAmount;
        this.totalAmount = totalAmount;
    }

    public Amount getMinAmount() {
        return minAmount;
    }

    public Amount getMaxAmount() {
        return maxAmount;
    }

    public Amount getEmiAmount() {
        return emiAmount;
    }

    public Amount getTotalAmount() {
        return totalAmount;
    }

    public String getPlanId() {
        return planId;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public String getOfMonths() {
        return ofMonths;
    }
}
