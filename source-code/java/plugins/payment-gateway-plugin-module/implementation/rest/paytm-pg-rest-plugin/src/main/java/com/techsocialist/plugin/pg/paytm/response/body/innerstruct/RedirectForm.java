package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class RedirectForm {

    @SerializedName("actionUrl")
    private String actionUrl;

    @SerializedName("method")
    private String method;

    @SerializedName("header")
    private Header header;

    @SerializedName("content")
    private FormContent content;

    public String getActionUrl() {
        return actionUrl;
    }

    public String getMethod() {
        return method;
    }

    public Header getHeader() {
        return header;
    }

    public FormContent getContent() {
        return content;
    }
}
