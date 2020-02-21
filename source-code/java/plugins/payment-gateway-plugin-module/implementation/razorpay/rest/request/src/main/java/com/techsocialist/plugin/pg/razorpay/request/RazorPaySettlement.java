package com.techsocialist.plugin.pg.razorpay.request;

import com.google.gson.annotations.SerializedName;

public class RazorPaySettlement extends AbstractRazorPayEntity{

    @SerializedName("amount")
    private long amount;

    @SerializedName("status")
    private String stauts;

    @SerializedName("fees")
    private long fees;

    @SerializedName("tax")
    private long tax;

    @SerializedName("utr")
    private String utr;

    public RazorPaySettlement setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public RazorPaySettlement setStauts(String stauts) {
        this.stauts = stauts;
        return this;
    }

    public RazorPaySettlement setFees(long fees) {
        this.fees = fees;
        return this;
    }

    public RazorPaySettlement setTax(long tax) {
        this.tax = tax;
        return this;
    }

    public RazorPaySettlement setUtr(String utr) {
        this.utr = utr;
        return this;
    }
}
