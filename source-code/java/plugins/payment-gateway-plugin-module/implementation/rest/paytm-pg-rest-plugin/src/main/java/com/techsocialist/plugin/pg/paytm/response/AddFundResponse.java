package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.AddFundResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.AddFundResponseHead;

public class AddFundResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private AddFundResponseHead addFundResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private AddFundResponseBody addFundResponseBody;

    public AddFundResponse() {
    }

    public AddFundResponseHead getAddFundResponseHead() {
        return addFundResponseHead;
    }

    public AddFundResponseBody getAddFundResponseBody() {
        return addFundResponseBody;
    }
}
