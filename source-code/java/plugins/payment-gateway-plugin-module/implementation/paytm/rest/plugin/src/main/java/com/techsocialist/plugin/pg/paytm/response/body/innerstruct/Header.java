package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class Header {

    @SerializedName("Content-Type")
    private String contentType;

    public String getContentType() {
        return contentType;
    }
}
