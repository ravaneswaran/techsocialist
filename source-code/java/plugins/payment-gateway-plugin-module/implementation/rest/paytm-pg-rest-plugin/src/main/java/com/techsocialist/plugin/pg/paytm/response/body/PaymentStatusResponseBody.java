package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;

public class PaymentStatusResponseBody extends AbstractPaytmResponseBody{

    @SerializedName("txnId")
    private String transactionId;

    @SerializedName("bankTxnId")
    private String bankTransactionId;

    @SerializedName("orderId")
    private String orderId;

    @SerializedName("txnAmount")
    private String transactionAmount;

    @SerializedName("txnType")
    private String transactionType;

    @SerializedName("gatewayName")
    private String gatewayName;

    @SerializedName("bankName")
    private String bankName;

    @SerializedName("mid")
    private String merchantId;

    @SerializedName("paymentMode")
    private String paymentMode;

    @SerializedName("refundAmt")
    private String refundAmount;

    @SerializedName("txnDate")
    private String transactionDate;

    public String getTransactionId() {
        return transactionId;
    }

    public String getBankTransactionId() {
        return bankTransactionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public String getBankName() {
        return bankName;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }
}
