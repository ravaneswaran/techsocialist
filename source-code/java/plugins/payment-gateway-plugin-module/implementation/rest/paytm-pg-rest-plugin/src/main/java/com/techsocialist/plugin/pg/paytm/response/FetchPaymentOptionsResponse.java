package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.FetchPaymentOptionsResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.FetchPaymentOptionsResponseHead;

public class FetchPaymentOptionsResponse extends AbstractPaytmResponse{

    @SerializedName("head")
    private FetchPaymentOptionsResponseHead fetchPaymentOptionsResponseHead;

    @SerializedName("body")
    private FetchPaymentOptionsResponseBody fetchPaymentOptionsResponseBody;

    public FetchPaymentOptionsResponseHead getFetchPaymentOptionsResponseHead() {
        return fetchPaymentOptionsResponseHead;
    }

    public FetchPaymentOptionsResponseBody getFetchPaymentOptionsResponseBody() {
        return fetchPaymentOptionsResponseBody;
    }

    @Override
    public boolean ok() {
        return this.fetchPaymentOptionsResponseBody.ok();
    }
}
