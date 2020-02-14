package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;

public class ValidateOTPResponseBody extends AbstractPaytmResponseBody {

    @SerializedName("authenticated")
    private boolean authenticated;

    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public boolean ok() {
        return "01".equals(this.getResultInfo().getResultCode());
    }
}


