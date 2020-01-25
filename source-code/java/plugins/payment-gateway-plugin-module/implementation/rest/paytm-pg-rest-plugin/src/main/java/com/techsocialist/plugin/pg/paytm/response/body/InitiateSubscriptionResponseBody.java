package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;

public class InitiateSubscriptionResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("extraParamsMap")
    private String extraParamsMap;

    public String getExtraParamsMap() {
        return extraParamsMap;
    }
}
