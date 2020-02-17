package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class BinDetail {

    @SerializedName("bin")
    private String bin;

    @SerializedName("issuingBank")
    private String issuingBank;

    @SerializedName("issuingBankCode")
    private String issuingBankCode;

    @SerializedName("paymentMode")
    private String paymentMode;

    @SerializedName("channelName")
    private String channelName;

    @SerializedName("channelCode")
    private String channelCode;

    @SerializedName("cnMin")
    private String cnMin;

    @SerializedName("cnMax")
    private String cnMax;

    @SerializedName("cvvR")
    private String cvvR;

    @SerializedName("cvvL")
    private String cvvL;

    @SerializedName("expR")
    private String expR;

    @SerializedName("isActive")
    private String isActive;

    @SerializedName("isIndian")
    private String isIndian;

    public String getBin() {
        return bin;
    }

    public String getIssuingBank() {
        return issuingBank;
    }

    public String getIssuingBankCode() {
        return issuingBankCode;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public String getCnMin() {
        return cnMin;
    }

    public String getCnMax() {
        return cnMax;
    }

    public String getCvvR() {
        return cvvR;
    }

    public String getCvvL() {
        return cvvL;
    }

    public String getExpR() {
        return expR;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getIsIndian() {
        return isIndian;
    }
}
