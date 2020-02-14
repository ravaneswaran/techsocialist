package com.techsocialist.plugin.pg.paytm.response.body.innerstruct;

import com.google.gson.annotations.SerializedName;

public class Amount {

    @SerializedName("currency")
    private String currency;

    @SerializedName("value")
    private String value;

    public Amount(){}

    public Amount(String currency, String value){
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getValue() {
        return value;
    }
}
