package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.ValidateAssetResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.ValidateAssetResponseHead;

public class ValidateAssetResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private ValidateAssetResponseHead validateAssetResponseHead;

    @SerializedName("body")
    private ValidateAssetResponseBody validateAssetResponseBody;

    public ValidateAssetResponseHead getValidateAssetResponseHead() {
        return validateAssetResponseHead;
    }

    public ValidateAssetResponseBody getValidateAssetResponseBody() {
        return validateAssetResponseBody;
    }

    @Override
    public boolean ok() {
        return this.getValidateAssetResponseBody().ok();
    }
}
