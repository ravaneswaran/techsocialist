package com.techsocialist.plugin.pg.paytm.response.head;

import com.google.gson.annotations.SerializedName;

public abstract class AbstractPaytmResponseHead {

    @SerializedName("requestId")
    private String requestId;

    @SerializedName("responseTimestamp")
    private String responseTimestamp;

    @SerializedName("version")
    private String version;

    public String getResponseTimestamp() {
        return responseTimestamp;
    }

    public String getVersion() {
        return version;
    }

    public String getRequestId() {
        return requestId;
    }
}
