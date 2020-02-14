package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;

public class CancelSubscriptionResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("mId")
    private String merchantId;

    @SerializedName("subsId")
    private String subscriptionId;

    @SerializedName("custId")
    private String customerId;

    @SerializedName("createdDate")
    private String createdDate;

    @SerializedName("expiryDate")
    private String expiryDate;

    public String getMerchantId() {
        return merchantId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public boolean ok() {
        return "200".equals(this.getResultInfo().getResultCode());
    }
}
