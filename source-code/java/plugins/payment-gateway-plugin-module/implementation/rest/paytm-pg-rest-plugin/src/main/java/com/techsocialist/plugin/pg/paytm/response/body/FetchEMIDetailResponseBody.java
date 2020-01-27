package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.innerstruct.EMIDetail;

public class FetchEMIDetailResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("emiDetail")
    private EMIDetail emiDetail;

    public EMIDetail getEmiDetail() {
        return emiDetail;
    }
}
