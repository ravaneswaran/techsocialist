package com.techsocialist.plugin.pg.paytm.response;

import com.google.gson.annotations.SerializedName;
import com.techsocialist.plugin.pg.paytm.response.body.MandateFormUploadResponseBody;
import com.techsocialist.plugin.pg.paytm.response.head.MandateFormUploadResponseHead;

public class MandateFormUploadResponse extends AbstractPaytmResponse {

    @SerializedName("head")
    private MandateFormUploadResponseHead mandateFormUploadResponseHead;

    @SerializedName("body")
    private MandateFormUploadResponseBody mandateFormUploadResponseBody;

    public MandateFormUploadResponseHead getMandateFormUploadResponseHead() {
        return mandateFormUploadResponseHead;
    }

    public MandateFormUploadResponseBody getMandateFormUploadResponseBody() {
        return mandateFormUploadResponseBody;
    }
}
