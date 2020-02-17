package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class IsDisabled {

    @SerializedName("status")
    private String status;

    @SerializedName("msg")
    private String message;

    @SerializedName("userAccountExist")
    private String userAccountExist;

    @SerializedName("merchantAccept")
    private String merchantAccept;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getUserAccountExist() {
        return userAccountExist;
    }

    public String getMerchantAccept() {
        return merchantAccept;
    }
}
