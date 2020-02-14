package com.techsocialist.plugin.pg.paytm.request;

import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.json.JSONObject;

public class FetchAllOffersRequest extends AbstractPaytmRequest {

    private String requestId;

    private String token;

    private String tokenType;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/theia/api/%s/fetchAllPaymentOffers?mid=%s";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/theia/api/%s/fetchAllPaymentOffers?mid=%s";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getVersion(), this.getMerchantId());
    }

    @Override
    public JSONObject dataHead() throws Exception {

        JSONObject head = new JSONObject();

        head.put("channelId", this.getChannelId());
        head.put("tokenType", this.tokenType);
        String checksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(this.getMerchantKey(), this.dataBody().toString());
        head.put("token", checksum);

        return head;
    }

    @Override
    public JSONObject dataBody() {

        JSONObject body = new JSONObject();

        body.put("mid", this.getMerchantId());

        return body;
    }

    public FetchAllOffersRequest setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }

    public FetchAllOffersRequest setToken(String token) {
        this.token = token;
        return this;
    }

    public FetchAllOffersRequest setTokenType(String tokenType) {
        this.tokenType = tokenType;
        return this;
    }
}
