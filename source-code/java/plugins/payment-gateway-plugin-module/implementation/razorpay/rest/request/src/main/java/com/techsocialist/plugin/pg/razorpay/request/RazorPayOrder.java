package com.techsocialist.plugin.pg.razorpay.request;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.razorpay.request.innerstruct.RazorPayNote;

public class RazorPayOrder extends AbstractRazorPayEntity {

    @SerializedName("amount")
    private long amount;

    @SerializedName("amount_paid")
    private long amountPaid;

    @SerializedName("amount_due")
    private long amountDue;

    @SerializedName("currency")
    private String currency;

    @SerializedName("receipt")
    private String receipt;

    @SerializedName("status")
    private String status;

    @SerializedName("attempts")
    private int attempts;

    @SerializedName("notes")
    private RazorPayNote[] razorPayNotes;

    public RazorPayOrder setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public RazorPayOrder setAmountPaid(long amountPaid) {
        this.amountPaid = amountPaid;
        return this;
    }

    public RazorPayOrder setAmountDue(long amountDue) {
        this.amountDue = amountDue;
        return this;
    }

    public RazorPayOrder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public RazorPayOrder setReceipt(String receipt) {
        this.receipt = receipt;
        return this;
    }

    public RazorPayOrder setStatus(String status) {
        this.status = status;
        return this;
    }

    public RazorPayOrder setAttempts(int attempts) {
        this.attempts = attempts;
        return this;
    }

    public RazorPayOrder setRazorPayNotes(RazorPayNote[] razorPayNotes) {
        this.razorPayNotes = razorPayNotes;
        return this;
    }
}
