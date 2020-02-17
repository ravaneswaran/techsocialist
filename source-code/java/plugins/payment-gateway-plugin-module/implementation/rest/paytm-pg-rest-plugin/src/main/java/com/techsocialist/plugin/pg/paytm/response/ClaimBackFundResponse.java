package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ClaimBackFundResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ClaimBackFundResponseHead;

public class ClaimBackFundResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private ClaimBackFundResponseHead claimBackFundResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private ClaimBackFundResponseBody claimBackFundResponseBody;

    public ClaimBackFundResponseHead getClaimBackFundResponseHead() {
        return claimBackFundResponseHead;
    }

    public ClaimBackFundResponseBody getClaimBackFundResponseBody() {
        return claimBackFundResponseBody;
    }
}
