package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class CancelSubscriptionRequest extends AbstractPaytmRequest {

    private String tokenType;

    private String ssoToken;

    private String subscriptionId;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/subscription/cancel";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/subscription/cancel";
    }

    @Override
    public String url(boolean production) {
        return this.getUrlEndPointPrefix(production);
    }

    @Override
    public JSONObject dataHead() throws Exception {
        JSONObject head = new JSONObject();
        head.put("version", this.getVersion());
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("tokenType", tokenType);
        if ("AES".equals(tokenType)) {
            String checksum = CheckSumServiceHelper.getCheckSumServiceHelper()
                    .genrateCheckSum(this.getMerchantKey(), dataBody().toString());
            head.put("signature", checksum);
        }

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        body.put("mid", this.getMerchantId());
        body.put("subsId", subscriptionId);
        if ("SSO".equals(tokenType)) {
            body.put("ssoToken", ssoToken);
        }

        return body;
    }

    public CancelSubscriptionRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }

    public CancelSubscriptionRequest setSsoToken(String ssoToken) {
        this.ssoToken = ssoToken;
        return this;
    }

    public CancelSubscriptionRequest setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }
}
