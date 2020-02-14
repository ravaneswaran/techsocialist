package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class RefundDetailInfo {

    @SerializedName("refundType")
    private String refundType;

    @SerializedName("payMethod")
    private String payMethod;

    @SerializedName("userCreditExpectedDate")
    private String userCreditExpectedDate;

    @SerializedName("userMobileNo")
    private String userMobileNumber;

    @SerializedName("refundAmount")
    private String refundAmount;

    public RefundDetailInfo(){

    }

    public RefundDetailInfo(String refundType, String payMethod, String userCreditExpectedDate, String userMobileNumber, String refundAmount){
        this.refundType = refundType;
        this.payMethod = payMethod;
        this.userCreditExpectedDate = userCreditExpectedDate;
        this.userMobileNumber = userMobileNumber;
        this.refundAmount = refundAmount;
    }

    public String getRefundType() {
        return refundType;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public String getUserCreditExpectedDate() {
        return userCreditExpectedDate;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public String getRefundAmount() {
        return refundAmount;
    }
}
