package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.CancelSubscriptionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.CancelSubscriptionResponseHead;

public class CancelSubscriptionResponse extends AbstractPaytmResponse{

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private CancelSubscriptionResponseHead cancelSubscriptionResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private CancelSubscriptionResponseBody cancelSubscriptionResponseBody;

    public CancelSubscriptionResponseHead getCancelSubscriptionResponseHead() {
        return cancelSubscriptionResponseHead;
    }

    public CancelSubscriptionResponseBody getCancelSubscriptionResponseBody() {
        return cancelSubscriptionResponseBody;
    }

    @Override
    public boolean ok() {
        return this.cancelSubscriptionResponseBody.ok();
    }
}
