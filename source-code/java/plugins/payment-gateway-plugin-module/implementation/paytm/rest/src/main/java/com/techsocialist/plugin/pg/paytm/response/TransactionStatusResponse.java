package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;

public class TransactionStatusResponse {

    @SerializedName("TXNID")
    private String transactionId;

    @SerializedName("BANKTXNID")
    private String bankTransactionId;

    @SerializedName("ORDERID")
    private String orderId;

    @SerializedName("TXNAMOUNT")
    private String transactionAmount;

    @SerializedName("STATUS")
    private String status;

    @SerializedName("TXNTYPE")
    private String transactionType;

    @SerializedName("GATEWAYNAME")
    private String gatewayName;

    @SerializedName("RESPCODE")
    private String responseCode;

    @SerializedName("RESPMSG")
    private String responseMessage;

    @SerializedName("BANKNAME")
    private String bankName;

    @SerializedName("MID")
    private String merchantId;

    @SerializedName("PAYMENTMODE")
    private String paymentMode;

    @SerializedName("REFUNDAMT")
    private String refundAmount;

    @SerializedName("TXNDATE")
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

    public String getStatus() {
        return status;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
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
