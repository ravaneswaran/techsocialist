package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.RefundDetailInfo;

import java.util.List;

public class RefundStatusResponseBody extends AbstractPaytmResponseBody{

    @SerializedName("orderId")
    private String orderId;

    @SerializedName("userCreditInitiateStatus")
    private String userCreditInitiateStatus;

    @SerializedName("mid")
    private String merchantId;

    @SerializedName("merchantRefundRequestTimestamp")
    private String merchantRefundRequestTimestamp;

    @SerializedName("txnTimestamp")
    private String transactionTimestamp;

    @SerializedName("acceptRefundTimestamp")
    private String acceptRefundTimestamp;

    @SerializedName("acceptRefundStatus")
    private String acceptRefundStatus;

    @SerializedName("userCreditInitiateTimestamp")
    private String userCreditInitiateTimestamp;

    @SerializedName("totalRefundAmount")
    private String totalRefundAmount;

    @SerializedName("refId")
    private String uniqueRefundId;

    @SerializedName("txnAmount")
    private String transactionAmount;

    @SerializedName("refundId")
    private String paytmRefundId;

    @SerializedName("txnId")
    private String transactionId;

    @SerializedName("refundAmount")
    private String refundAmount;

    @SerializedName("refundDetailInfoList")
    private List<RefundDetailInfo> refundDetailInfoList;

    public String getOrderId() {
        return orderId;
    }

    public String getUserCreditInitiateStatus() {
        return userCreditInitiateStatus;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getMerchantRefundRequestTimestamp() {
        return merchantRefundRequestTimestamp;
    }

    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public String getAcceptRefundTimestamp() {
        return acceptRefundTimestamp;
    }

    public String getAcceptRefundStatus() {
        return acceptRefundStatus;
    }

    public String getUserCreditInitiateTimestamp() {
        return userCreditInitiateTimestamp;
    }

    public String getTotalRefundAmount() {
        return totalRefundAmount;
    }

    public String getUniqueRefundId() {
        return uniqueRefundId;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public String getPaytmRefundId() {
        return paytmRefundId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public List<RefundDetailInfo> getRefundDetailInfoList() {
        return refundDetailInfoList;
    }
}
