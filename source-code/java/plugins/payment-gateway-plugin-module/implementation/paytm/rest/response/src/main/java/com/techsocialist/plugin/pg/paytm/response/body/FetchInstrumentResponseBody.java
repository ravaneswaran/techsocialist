package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.PayOption;

import java.util.List;

public class FetchInstrumentResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("payOptions")
    private List<PayOption> payOptions;

    public List<PayOption> getPayOptions() {
        return payOptions;
    }
}
