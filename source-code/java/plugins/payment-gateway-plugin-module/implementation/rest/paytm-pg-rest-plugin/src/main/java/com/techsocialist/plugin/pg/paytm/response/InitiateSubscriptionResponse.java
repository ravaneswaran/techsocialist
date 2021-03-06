package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.InitiateSubscriptionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.InitiateSubscriptionResponseHead;

public class InitiateSubscriptionResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private InitiateSubscriptionResponseHead initiateSubscriptionResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private InitiateSubscriptionResponseBody initiateSubscriptionResponseBody;

    public InitiateSubscriptionResponseHead getInitiateSubscriptionResponseHead() {
        return initiateSubscriptionResponseHead;
    }

    public InitiateSubscriptionResponseBody getInitiateSubscriptionResponseBody() {
        return initiateSubscriptionResponseBody;
    }
}
