package com.techsocialist.plugin.pg.paytm.response.body;

import com.google.gson.annotations.SerializedName;


public class InitiateTransactionResponseBody extends AbstractPaytmResponseBody{

    @SerializedName("txnToken")
    private String transactionToken;

    @SerializedName("isPromoCodeValid")
    private boolean isPromoCodeValid;

    @SerializedName("authenticated")
    private boolean authenticated;

    @SerializedName("extraParamsMap")
    private String extraParamsMap;

    public String getTransactionToken() {
        return transactionToken;
    }

    public boolean isPromoCodeValid() {
        return isPromoCodeValid;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getExtraParamsMap() {
        return extraParamsMap;
    }
}
