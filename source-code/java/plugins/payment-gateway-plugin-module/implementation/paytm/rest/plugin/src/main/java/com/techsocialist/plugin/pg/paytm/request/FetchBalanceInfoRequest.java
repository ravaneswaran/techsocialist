package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class FetchBalanceInfoRequest extends AbstractPaytmRequest {

    private String paymentMode;

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in/userAsset";
    }

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in/userAsset";
    }

    @Override
    public String url(boolean production) {
        return String.format("%s/fetchBalanceInfo?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        //com.techsocialist.plugin.pg.paytm.response.head.put("clientId", this.getClientId());
        //com.techsocialist.plugin.pg.paytm.response.head.put("version", this.getVersion());
        head.put("requestTimestamp", this.getRequestTimestamp());
        head.put("channelId", this.getChannelId());
        head.put("txnToken", this.getTransactionToken());

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        body.put("paymentMode", this.paymentMode);

        return body;
    }

    public FetchBalanceInfoRequest setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
        return this;
    }
}
