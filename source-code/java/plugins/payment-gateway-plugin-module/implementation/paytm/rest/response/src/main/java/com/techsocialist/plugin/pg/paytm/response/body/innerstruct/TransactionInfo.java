package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class TransactionInfo {

    @SerializedName("BANKNAME")
    private String bankName;

    @SerializedName("BANKTXNID")
    private String bankTransactionId;

    @SerializedName("CHECKSUMHASH")
    private String checkSumHash;

    @SerializedName("CURRENCY")
    private String currency;

    @SerializedName("GATEWAYNAME")
    private String gatewayName;

    @SerializedName("MID")
    private String merchantId;

    @SerializedName("ORDERID")
    private String orderId;

    @SerializedName("RESPCODE")
    private String responseCode;

    @SerializedName("RESPMSG")
    private String responseMessage;

    @SerializedName("STATUS")
    private String status;

    @SerializedName("TXNAMOUNT")
    private String transactionAmount;

    @SerializedName("TXNDATE")
    private String transactionDate;

    @SerializedName("TXNID")
    private String transactionId;

    public String getBankTransactionId() {
        return bankTransactionId;
    }

    public String getCheckSumHash() {
        return checkSumHash;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public String getStatus() {
        return status;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public String getGatewayName() {
        return gatewayName;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
