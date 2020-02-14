package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;

public class RefundResponseBody extends AbstractPaytmResponseBody{

    @SerializedName("txnTimestamp")
    private String transactionTimestamp;

    @SerializedName("orderId")
    private String orderId;

    @SerializedName("mid")
    private String merchantId;

    @SerializedName("refId")
    private String uniqueRefundId;

    @SerializedName("refundId")
    private String paytmRefundId;

    @SerializedName("txnId")
    private String transactionId;

    @SerializedName("refundAmount")
    private String refundAmount;

    public String getTransactionTimestamp() {
        return transactionTimestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getUniqueRefundId() {
        return uniqueRefundId;
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
}
