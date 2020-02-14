package com.techsocialist.plugin.pg.paytm.response.head;

import com.google.gson.annotations.SerializedName;

public class MandateFormUploadResponseHead extends AbstractPaytmResponseHead {

    @SerializedName("timestamp")
    private String timestamp;

    public String getTimestamp() {
        return timestamp;
    }

}
