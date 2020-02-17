package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class AccountListRequest extends AbstractPaytmRequest {

    private String subwalletGuid;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://staging-dashboard.paytm.com/bpay/api/%s/account/list";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://dashboard.paytm.com/bpay/api/%s/account/list";
    }

    @Override
    public String url(boolean production) {
        return String.format(this.getUrlEndPointPrefix(production), this.getVersion());
    }

    @Override
    public JSONObject data() throws Exception {
        return this.dataBody();
    }

    @Override
    public JSONObject dataHead() throws Exception {
        return null;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject paytmParams = new JSONObject();

        paytmParams.put("subwalletGuid", this.subwalletGuid);

        return paytmParams;
    }

    public AccountListRequest setSubwalletGuid(String subwalletGuid) {
        this.subwalletGuid = subwalletGuid;
        return this;
    }
}
