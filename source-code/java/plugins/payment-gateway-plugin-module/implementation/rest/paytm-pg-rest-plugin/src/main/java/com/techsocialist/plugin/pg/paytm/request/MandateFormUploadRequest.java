package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class MandateFormUploadRequest extends AbstractPaytmRequest {

    private String tokenType;

    private String subscriptionId;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/subscription/paper/mandate/uploadUrl";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/subscription/paper/mandate/uploadUrl";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {

        JSONObject head = new JSONObject();

        head.put("tokenType", this.tokenType);
        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());
        head.put("signature", checksum);


        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());
        body.put("subscriptionId", this.subscriptionId);

        return body;
    }

    public MandateFormUploadRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public MandateFormUploadRequest setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }
}
