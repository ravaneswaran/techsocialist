package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ResendNotificationLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ResendNotificationLinkResponseHead;

public class ResendNotificationLinkResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private ResendNotificationLinkResponseHead resendNotificationLinkResponseHead;

    @SerializedName("body")
    private ResendNotificationLinkResponseBody resendNotificationLinkResponseBody;

    public ResendNotificationLinkResponseHead getResendNotificationLinkResponseHead() {
        return resendNotificationLinkResponseHead;
    }

    public ResendNotificationLinkResponseBody getResendNotificationLinkResponseBody() {
        return resendNotificationLinkResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getResendNotificationLinkResponseBody().ok();
    }
}
