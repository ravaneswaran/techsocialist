package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class FetchSubscriptionStatusRequest extends AbstractPaytmRequest {

    private String subscriptionId;

    private String customerId;

    private String tokenType;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/subscription/checkStatus";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/subscription/checkStatus";
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
        body.put("subsId", this.subscriptionId);
        body.put("custId", this.customerId);

        return body;
    }

    public FetchSubscriptionStatusRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public FetchSubscriptionStatusRequest setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    public FetchSubscriptionStatusRequest setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }
}
