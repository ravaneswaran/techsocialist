package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.UpdateLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.UpdateLinkResponseHead;

public class UpdateLinkResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private UpdateLinkResponseHead updateLinkResponseHead;

    @SerializedName("body")
    private UpdateLinkResponseBody updateLinkResponseBody;

    public UpdateLinkResponseHead getUpdateLinkResponseHead() {
        return updateLinkResponseHead;
    }

    public UpdateLinkResponseBody getUpdateLinkResponseBody() {
        return updateLinkResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getUpdateLinkResponseBody().ok();
    }
}
