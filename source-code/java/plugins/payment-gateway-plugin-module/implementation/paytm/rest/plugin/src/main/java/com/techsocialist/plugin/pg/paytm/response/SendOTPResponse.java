package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.SendOTPResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.SendOTPResponseHead;

public class SendOTPResponse extends AbstractPaytmResponse {

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.head")
    private SendOTPResponseHead sendOTPResponseHead;

    @SerializedName("com.techsocialist.plugin.pg.paytm.response.body")
    private SendOTPResponseBody sendOTPResponseBody;

    public SendOTPResponseHead getSendOTPResponseHead() {
        return sendOTPResponseHead;
    }

    public SendOTPResponseBody getSendOTPResponseBody() {
        return sendOTPResponseBody;
    }
}
