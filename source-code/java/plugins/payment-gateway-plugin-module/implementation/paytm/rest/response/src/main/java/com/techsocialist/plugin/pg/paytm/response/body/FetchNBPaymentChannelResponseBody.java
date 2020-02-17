package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.NBPayOption;

public class FetchNBPaymentChannelResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("nbPayOption")
    private NBPayOption nBPayOption;

    public NBPayOption getNBPayOption() {
        return nBPayOption;
    }
}
