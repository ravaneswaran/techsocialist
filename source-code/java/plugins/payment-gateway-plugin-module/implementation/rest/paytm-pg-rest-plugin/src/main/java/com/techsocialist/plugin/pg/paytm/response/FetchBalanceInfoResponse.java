package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchBalanceInfoResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchBalanceInfoResponseHead;

public class FetchBalanceInfoResponse extends AbstractPaytmResponse{

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private FetchBalanceInfoResponseHead fetchBalanceInfoResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private FetchBalanceInfoResponseBody fetchBalanceInfoResponseBody;

    public FetchBalanceInfoResponseHead getFetchBalanceInfoResponseHead() {
        return fetchBalanceInfoResponseHead;
    }

    public FetchBalanceInfoResponseBody getFetchBalanceInfoResponseBody() {
        return fetchBalanceInfoResponseBody;
    }
}
