package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ValidateOTPResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ValidateOTPResponseHead;

public class ValidateOTPResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private ValidateOTPResponseHead validateOTPResponseHead;

    @SerializedName("body")
    private ValidateOTPResponseBody validateOTPResponseBody;

    public ValidateOTPResponseHead getValidateOTPResponseHead() {
        return validateOTPResponseHead;
    }

    public ValidateOTPResponseBody getValidateOTPResponseBody() {
        return validateOTPResponseBody;
    }
}
