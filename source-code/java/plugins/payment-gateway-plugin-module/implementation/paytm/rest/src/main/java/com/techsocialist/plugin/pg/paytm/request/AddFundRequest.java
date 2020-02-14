package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class AddFundRequest extends AbstractPaytmRequest{

    private String subwalletGuid;

    private String amount;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://staging-dashboard.paytm.com/bpay/api/%s/account/credit";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://dashboard.paytm.com/bpay/api/%s/account/credit";
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
        paytmParams.put("amount", this.amount);

        return paytmParams;
    }

    public AddFundRequest setSubwalletGuid(String subwalletGuid) {
        this.subwalletGuid = subwalletGuid;
        return this;
    }

    public AddFundRequest setAmount(String amount) {
        this.amount = amount;
        return this;
    }
}
