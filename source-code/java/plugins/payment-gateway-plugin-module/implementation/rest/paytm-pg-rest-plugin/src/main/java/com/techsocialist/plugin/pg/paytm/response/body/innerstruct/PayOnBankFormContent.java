package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class PayOnBankFormContent extends FormContent{

    @SerializedName("bankCode")
    private String bankCode;

    @SerializedName("mbid")
    private String mbid;

    @SerializedName("orderId")
    private String orderId;

    @SerializedName("txnamount")
    private String transactionAmount;

    @SerializedName("paymentMode")
    private String paymentMode;

    @SerializedName("response")
    private String response;

    @SerializedName("bankAbbr")
    private String bankAbbreviation;

    @SerializedName("channelid")
    private String channelId;

    @SerializedName("txnid")
    private String transactionId;

    public String getBankCode() {
        return bankCode;
    }

    public String getMbid() {
        return mbid;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getResponse() {
        return response;
    }

    public String getBankAbbreviation() {
        return bankAbbreviation;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getTransactionId() {
        return transactionId;
    }
}
