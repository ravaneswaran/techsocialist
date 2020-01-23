package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class DirectForm {

    @SerializedName("actionUrl")
    private String actionUrl;

    @SerializedName("method")
    private String method;

    @SerializedName("type")
    private String type;

    @SerializedName("headers")
    private Header header;

    @SerializedName("content")
    private FormContent content;

    public String getActionUrl() {
        return actionUrl;
    }

    public String getMethod() {
        return method;
    }

    public String getType() {
        return type;
    }

    public Header getHeader() {
        return header;
    }

    public FormContent getContent() {
        return content;
    }
}
