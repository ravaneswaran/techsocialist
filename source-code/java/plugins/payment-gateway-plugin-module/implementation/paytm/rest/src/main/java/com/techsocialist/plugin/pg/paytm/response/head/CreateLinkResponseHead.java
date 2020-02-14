package com.techsocialist.plugin.pg.paytm.response.head;

import com.google.gson.annotations.SerializedName;

public class CreateLinkResponseHead extends AbstractPaytmResponseHeadWithSignature {

    @SerializedName("channelId")
    private String channelId;

    @SerializedName("tokenType")
    private String tokenType;

    @SerializedName("clientId")
    private String clientId;

    @SerializedName("timestamp")
    private String timestamp;

    public String getChannelId() {
        return channelId;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
