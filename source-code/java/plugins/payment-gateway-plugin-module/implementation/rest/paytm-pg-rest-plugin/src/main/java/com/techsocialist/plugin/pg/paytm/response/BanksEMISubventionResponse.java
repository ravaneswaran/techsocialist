package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.BanksEMISubventionResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.BanksEMISubventionResponseHead;

public class BanksEMISubventionResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private BanksEMISubventionResponseHead banksEMISubventionResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private BanksEMISubventionResponseBody banksEMISubventionResponseBody;

    public BanksEMISubventionResponseHead getBanksEMISubventionResponseHead() {
        return banksEMISubventionResponseHead;
    }

    public BanksEMISubventionResponseBody getBanksEMISubventionResponseBody() {
        return banksEMISubventionResponseBody;
    }
}
