package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchLinkResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchLinkResponseHead;

public class FetchLinkResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private FetchLinkResponseHead fetchLinkResponseHead;

    @SerializedName("body")
    private FetchLinkResponseBody fetchLinkResponseBody;

    public FetchLinkResponseHead getFetchLinkResponseHead() {
        return fetchLinkResponseHead;
    }

    public FetchLinkResponseBody getFetchLinkResponseBody() {
        return fetchLinkResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getFetchLinkResponseBody().ok();
    }
}
