package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.DisburseStatusQueryResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.DisburseStatusQueryResponseHead;

public class DisburseStatusQueryResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private DisburseStatusQueryResponseHead disburseStatusQueryResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private DisburseStatusQueryResponseBody disburseStatusQueryResponseBody;

    public DisburseStatusQueryResponseHead getDisburseStatusQueryResponseHead() {
        return disburseStatusQueryResponseHead;
    }

    public DisburseStatusQueryResponseBody getDisburseStatusQueryResponseBody() {
        return disburseStatusQueryResponseBody;
    }
}
