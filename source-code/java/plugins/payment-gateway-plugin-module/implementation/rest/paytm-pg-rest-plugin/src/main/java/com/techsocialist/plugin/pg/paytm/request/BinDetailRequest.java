package com.techsocialist.plugin.pg.paytm.request;

import org.json.JSONObject;

public class BinDetailRequest extends AbstractPaytmRequest {

    private String bin;

    @Override
    protected String getStagingUrlEndPointPrefix() {
        return "https://securegw-stage.paytm.in";
    }

    @Override
    protected String getProductionUrlEndPointPrefix() {
        return "https://securegw.paytm.in";
    }

    @Override
    public String url(boolean production) {
        return String.format("%s/fetchBinDetail?mid=%s&orderId=%s", this.getUrlEndPointPrefix(production), this.getMerchantId(), this.getOrderId());
    }

    @Override
    public JSONObject dataHead() {
        JSONObject head = new JSONObject();
        head.put("version", this.getVersion());
        head.put("requestTimestamp", System.currentTimeMillis());
        head.put("channelId", this.getChannelId());
        head.put("txnToken", this.getTransactionToken());

        return head;
    }

    @Override
    public JSONObject dataBody() {
        JSONObject body = new JSONObject();
        body.put("bin", bin);

        return body;
    }

    public BinDetailRequest setBin(String bin) {
        this.bin = bin;
        return this;
    }
}
