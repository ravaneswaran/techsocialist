package com.techsocialist.plugin.pg.paytm.response.head;

import com.google.gson.annotations.SerializedName;

public class FetchInstrumentResponseHead extends AbstractPaytmResponseHead {

    @SerializedName("clientId")
    private String clientId;

    public String getClientId() {
        return clientId;
    }
}
