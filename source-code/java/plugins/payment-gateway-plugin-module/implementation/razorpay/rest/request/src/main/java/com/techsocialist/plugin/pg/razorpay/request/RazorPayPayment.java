package com.techsocialist.plugin.pg.razorpay.request;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.razorpay.request.innerstruct.RazorPayNote;

public class RazorPayPayment extends AbstractRazorPayEntity{

    @SerializedName("amount")
    private long amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("status")
    private String status;

    @SerializedName("method")
    private String method;

    @SerializedName("order_id")
    private String orderId;

    @SerializedName("description")
    private String description;

    @SerializedName("amount_refunded")
    private long amountRefunded;

    @SerializedName("refund_status")
    private String refundStatus;

    @SerializedName("email")
    private String email;

    @SerializedName("contact")
    private String contact;

    @SerializedName("notes")
    private RazorPayNote[] razorPayNotes;

    @SerializedName("fee")
    private long fee;

    @SerializedName("tax")
    private long tax;

    @SerializedName("error_code")
    private String errorCode;

    @SerializedName("error_description")
    private String errorDescription;

    public RazorPayPayment setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public RazorPayPayment setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public RazorPayPayment setStatus(String status) {
        this.status = status;
        return this;
    }

    public RazorPayPayment setMethod(String method) {
        this.method = method;
        return this;
    }

    public RazorPayPayment setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public RazorPayPayment setDescription(String description) {
        this.description = description;
        return this;
    }

    public RazorPayPayment setAmountRefunded(long amountRefunded) {
        this.amountRefunded = amountRefunded;
        return this;
    }

    public RazorPayPayment setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
        return this;
    }

    public RazorPayPayment setEmail(String email) {
        this.email = email;
        return this;
    }

    public RazorPayPayment setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public RazorPayPayment setRazorPayNotes(RazorPayNote[] razorPayNotes) {
        this.razorPayNotes = razorPayNotes;
        return this;
    }

    public RazorPayPayment setFee(long fee) {
        this.fee = fee;
        return this;
    }

    public RazorPayPayment setTax(long tax) {
        this.tax = tax;
        return this;
    }

    public RazorPayPayment setErrorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public RazorPayPayment setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
        return this;
    }
}
